package lsbasi;

public class Interpreter {
	private String text;
	private int pos;
	private Token currentToken;
	private char currentChar;

	public Interpreter(String text) {
		super();
		this.text = text;
		pos = 0;
		currentToken = null;
		currentChar = text.charAt(pos);
	}

	Token getNextToken() throws Exception {
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

	String getNumber() {
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

	public int expr() throws Exception {
		currentToken = getNextToken();
		int left = Integer.parseInt(currentToken.value);
		eat(TokenType.INTEGER);
		do {
			Token op = currentToken;

			eat(op.type);
			int right = Integer.parseInt(currentToken.value);
			eat(TokenType.INTEGER);

			if (op.type == TokenType.PLUS) {
				left = left + right;
			} else if (op.type == TokenType.MINUS) {
				left = left - right;
			} else if (op.type == TokenType.MULTI) {
				left = left * right;
			} else if (op.type == TokenType.DIV) {
				left = left / right;
			} else {
				error();
			}
		}

		while (currentToken.type != TokenType.EOF);

		return left;

	}

	private void eat(TokenType type) throws Exception {
		if (currentToken.type == type) {

			currentToken = getNextToken();
			return;
		}
		throw new Exception("parse error");
	}
}
