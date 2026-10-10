// [FILENAME]: Token.java

package com.seth.squid.lang;

public class Token {
	// object from TokenType class
	private final TokenType type;
	private final String 	lexeme;
	
	// literal can be String, Integer, or null depending on the token
	// Object data type covers all cases
	private final Object 	literal;
	private final String 	span;
	
	public Token(TokenType type, String lexeme, Object literal, String span) {
		this.type 	 = type;
		this.lexeme  = lexeme;
		this.literal = literal;
		this.span 	 = span;
	}
	
	// getters
	public TokenType getTokenType() { return type; 	  }
	public String 	 getLexeme() 	{ return lexeme;  }
	public Object 	 getLiteral() 	{ return literal; }
	public String 	 getSpan() 		{ return span; 	  }
	
	public String toFormat() {
		return String.format("[lexeme= %s, token_type= %s, literal= %s, span= %s]", getLexeme(), getTokenType(), getLiteral(), getSpan());
	}
}