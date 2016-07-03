package lsbasi;

public enum TokenType {
	INTEGER, PLUS('+'), MINUS('-'), MULTI('*'), DIV('/'), EOF, LPAREN, RLPAREN;
	private char opChar;

	TokenType(char c) {
		this.opChar = c;
	}

	TokenType() {
	}

	public char getOpChar() {
		return opChar;
	}



}
