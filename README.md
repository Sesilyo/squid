# Squid
**Author:** Sesilyo

## Overview
Squid is a personal command-line logging tool with its own command language, also called Squid. Written in Java.

## Download and Set Up
TBD

## Manual
Squid is terminal-based. Use `sqd` as the base command before any operation.

### Quick Start
```text
sqd --init log
sqd --see logs
sqd --commands
```

## Commands
Always prefix with `sqd`:

| Command | Purpose |
| ---: | :--- |
| `--version` | Check current Squid version |
| `--commands` | Print all available commands |
| `--crumbs` | Print command breadcrumb history |
| `--check time` | Print current time |
| `--check date` | Print current date |
| `--check datetime` | Print current date and time |
| `--init log` | Initialize a new log entry |
| `--init tag` | Initialize a new tag |
| `--init proj` | Initialize a new project |
| `--see logs` | Print all logs |
| `--see logs <tag \| project>` | Print all logs under a tag or project |
| `--see logs <tag \| project> <n>` | Print the last n logs under a tag or project |

## Examples

### Check version
```text
sqd --version
Squid version alpha
```

### Initialize a new log
```text
sqd --init log
```

### See all logs tagged CODING
```text
sqd --see logs CODING
```

### See last 5 logs under a project
```text
sqd --see logs kalApp 5
```