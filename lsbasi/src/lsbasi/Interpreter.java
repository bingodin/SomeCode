package lsbasi;

public class Interpreter {
	String text;
	int pos = 0;
	Token currentToken;

	public Interpreter(String text) {
		super();
		this.text = text;
	}

	Token getNextToken() throws Exception {
		if (pos > text.length() - 1) {
			return new Token(TokenType.EOF, null);
		}
		char currentChar = text.charAt(pos);
		if (Character.isDigit(currentChar)) {
			pos++;
			return new Token(TokenType.INTEGER, currentChar + "");
		}
		if (currentChar == '+') {
			pos++;
			return new Token(TokenType.PLUS, "+");
		}
		error();
		return currentToken;
	}

	private void error() throws Exception {
		throw new Exception("parse error");
	}

	public int expr() throws Exception {
		currentToken = getNextToken();
		eat(TokenType.INTEGER);
		int left = Integer.parseInt(currentToken.value);

		currentToken = getNextToken();
		eat(TokenType.PLUS);

		currentToken = getNextToken();
		eat(TokenType.INTEGER);
		int right = Integer.parseInt(currentToken.value);
		currentToken = getNextToken();
		eat(TokenType.EOF);
		currentToken = getNextToken();
		eat(TokenType.EOF);
		return left + right;
	}

	private void eat(TokenType type) throws Exception {
		if (currentToken.type == type) {
			return;
		}
		throw new Exception("parse error");
	}
}
