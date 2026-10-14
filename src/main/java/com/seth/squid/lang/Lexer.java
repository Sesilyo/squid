// [FILENAME]: Lexer.java
package com.seth.squid.lang;

import java.util.ArrayList;

public class Lexer {
	private final String source;
	private final ArrayList<Token> tokens;
	private int tokenStart;
	private int cursorPos;
	private int line;
	private final Boolean hadError;
	
	public Lexer(String source) {
		
		this.source   	= source;
		this.tokens   	= new ArrayList<Token>();
		this.tokenStart = 0;
		this.cursorPos  = 0;
		this.line     	= 1;
		this.hadError 	= false;
	}
	
	// checks if cursor position is at the end
	private Boolean isAtEnd() {
		return this.cursorPos >= this.source.length();
	}
	
	
	// returns current char and increments cursor position
	private char advance() {
		char currentChar = this.source.charAt(this.cursorPos);
		this.cursorPos++;
		return currentChar;
	}
	
	// returns current char without advancing
	private char peek() {
		return this.source.charAt(this.cursorPos);
	}
	
	// creates a Token and adds to list
	private void addToken(TokenType tokenType, Literal literal) {
		String lexeme = this.source.substring(this.tokenStart, this.cursorPos);
		String span   = String.format("%d:%d-$d", this.line, this.tokenStart, this.cursorPos);
	}
	
	private ArrayList scanTokensLoop() {
		int tokenStart = this.cursorPos;
		while (!isAtEnd()) {
			
		}
		return tokens;
	}
}
