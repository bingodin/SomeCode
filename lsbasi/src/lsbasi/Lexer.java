package lsbasi;

public class Lexer {
	private String text;
	private int pos;
	private Token currentToken;
	private char currentChar;

	public Lexer(String text) {
		this.text = text;
		pos = 0;
		currentToken = null;
		currentChar = text.charAt(pos);
	}

	public Token getNextToken() throws Exception {
		if (pos > text.length() - 1) {
			return new Token(TokenType.EOF, null);
		}
		skipWiteSpace();
		char currentChar = text.charAt(pos);
		if (Character.isDigit(currentChar)) {
			return new Token(TokenType.INTEGER, getNumber());
		}
		if (currentChar == '+') {
			advace();
			return new Token(TokenType.PLUS, "+");
		}
		if (currentChar == '-') {
			advace();
			return new Token(TokenType.MINUS, "+");
		}
		if (currentChar == '*') {
			advace();
			return new Token(TokenType.MULTI, "*");
		}
		if (currentChar == '/') {
			advace();
			return new Token(TokenType.DIV, "/");
		}
		if (currentChar == '(') {
			advace();
			return new Token(TokenType.LPAREN, "(");
		}
		if (currentChar == ')') {
			advace();
			return new Token(TokenType.RLPAREN, ")");
		}
		error();
		return currentToken;
	}

	private void skipWiteSpace() {
		while (Character.isSpaceChar(currentChar)) {
			advace();
		}
	}

	private void advace() {
		pos++;

		if (pos > text.length() - 1) {
			currentChar = Character.MIN_VALUE;
		} else {
			currentChar = text.charAt(pos);
		}
	}

	private String getNumber() {
		StringBuilder s = new StringBuilder();
		while (Character.isDigit(currentChar)) {
			s.append(currentChar);
			advace();
		}
		return s.toString();
	}

	private void error() throws Exception {
		throw new Exception("parse error");
	}
}
