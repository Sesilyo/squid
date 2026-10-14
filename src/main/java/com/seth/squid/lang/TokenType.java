// [FILENAME]: TokenType.java
package com.seth.squid.lang;

public enum TokenType {
    // verbs
    INIT,
    SEE,
    CHECK,

    // subjects
    LOG, LOGS,
    TAG, PROJ,
    TIME, DATE, DATETIME,

    // flags
    VERSION,
    COMMANDS,
    CRUMBS,
    TOKENIZE,
    PARSE,
    
    // literals
    LOG_CONTENT, IDENTIFIER, NUMBER,

    // special
    UNKNOWN, NIL
}