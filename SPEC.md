# Squid Language Specification
**Author:** Sesilyo<br>
**Host Language:** Java<br>
**Execution Model:** Interpreted, dynamically typed

---

## 1. Overview & Design Rationale

- **Purpose:** Squid is the command language of the Squid CLI tool — a personal logging system.
- **Typing System:** Dynamically typed
- **Input Source:** Terminal arguments (`args[]`), not a file
- **Design Rationale:** Squid is purpose-built for S-Logger operations. Its grammar is minimal and intentional — every token maps directly to a logging action.

---

## 2. CLI Run Contract & Interface

| Invocation | Description | Output |
| :--- | :--- | :--- |
| `./build.sh` | Compile Java source into executable | N/A |
| `sqd --tokenize <input>` | Scan input and print deterministic token stream | `stdout` |
| `sqd --parse <input>` | Parse token stream and print prefix AST | `stdout` |
| `sqd` | Start interactive REPL | `stdout` |
| `sqd <command>` | Execute a single Squid command | `stdout` |

---

## 3. Token Output Format

The token stream emitted by `sqd --tokenize` is deterministic and formatted as follows (one token per line):

```text
[lexeme = , token_type = , literal = , span = ]
```

---

## 4. Lexical Grammar & Token Types

### A. Token Data Structure
Every token carries four components:

- `token_type`&nbsp;— A `TokenType` enum value
- `lexeme`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;— The raw string slice from input
- `literal`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;— The evaluated object value (null for non-literals)
- `span`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;— Position in the input for error reporting

### B. TokenType Enumeration

**Verbs (actions):**
- `INIT`&nbsp;&nbsp;&nbsp;— `--init`
- `SEE`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;— `--see`
- `CHECK` — `--check`

**Subjects (targets of verbs):**
- `LOG` — `log`
- `LOGS` — `logs`
- `TAG` — `tag`
- `PROJ` — `proj`
- `TIME` — `time`
- `DATE` — `date`
- `DATETIME` — `datetime`

**Flags (standalone commands):**
- `VERSION` — `--version`
- `COMMANDS` — `--commands`
- `CRUMBS` — `--crumbs`
- `TOKENIZE` — `--tokenize`
- `PARSE` — `--parse`

**Literals:**
- `LOG_CONTENT` — quoted string content of a log entry
- `IDENTIFIER` — tag name or project name (unquoted)
- `NUMBER` — integer, e.g. `5` in `--see logs CODING 5`

**Special:**
- `UNKNOWN` — unrecognized token
- `EOF` — end of input

### C. Literal Evaluation Rules

- **Numbers:** Integer strings evaluated to host `int` type
- **Strings:** Text bounded by double quotes (`"..."`), stripping outer quotes and evaluating escape sequences (`\n`, `\t`)
- **Identifiers:** Unquoted alphanumeric strings — tag names, project names

---

## 5. Grammar (Informal)

```
command     → flag
            | verb subject
            | verb subject identifier
            | verb subject identifier number

flag        → --version | --commands | --crumbs

verb        → --init | --see | --check

subject     → log | logs | tag | proj
            | time | date | datetime

identifier  → [a-zA-Z][a-zA-Z0-9_]*

number      → [0-9]+
```

---

## 6. Error Handling

- Unrecognized tokens emit `UNKNOWN` and print to `stderr`:
```text
squid: unrecognized command '--inti'
squid: did you mean '--init'?
```
- Missing required subject after verb prints usage hint
- Invalid literal types print type mismatch message