package lsbasi;

public class Interpreter {

	private Lexer lexer;
	private Token currentToken;

	public Interpreter(Lexer lexer) throws Exception {
		this.lexer = lexer;
		currentToken = lexer.getNextToken();
	}

	int factor() throws Exception {
		Token token = currentToken;
		eat(TokenType.INTEGER);
		return Integer.parseInt(token.value);
	}

	public int expr() throws Exception {
		int result = factor();

		while (currentToken.type == TokenType.DIV || currentToken.type == TokenType.MULTI) {
			Token token = currentToken;
			eat(token.type);
			if (token.type == TokenType.DIV) {
				result /= factor();
			} else {
				result *= factor();
			}
		}
		eat(TokenType.EOF);
		return result;
	}

	private void eat(TokenType type) throws Exception {
		if (currentToken.type == type) {

			currentToken = lexer.getNextToken();
			return;
		}
		throw new Exception("parse error");
	}
}
