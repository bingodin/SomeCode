package lsbasi;

public class Interpreter {

	private Lexer lexer;
	private Token currentToken;

	public Interpreter(Lexer lexer) throws Exception {
		this.lexer = lexer;
		currentToken = lexer.getNextToken();
	}

	public int expr() throws Exception {
		int result = term();

		while (currentToken.type == TokenType.PLUS || currentToken.type == TokenType.MINUS) {
			Token token = currentToken;
			eat(token.type);
			if (token.type == TokenType.PLUS) {
				result += term();
			} else {
				result -= term();
			}
		}
		return result;
	}

	public int term() throws Exception {
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
		return result;
	}

	int factor() throws Exception {
		Token token = currentToken;
		if (token.type == TokenType.INTEGER) {

			eat(TokenType.INTEGER);
			return Integer.parseInt(token.value);
		} else if (token.type == TokenType.LPAREN) {
			eat(TokenType.LPAREN);
			int r = expr();
			eat(TokenType.RLPAREN);
			return r;
		}
		throw new Exception("parse error");
	}

	private void eat(TokenType type) throws Exception {
		if (currentToken.type == type) {

			currentToken = lexer.getNextToken();
			return;
		}
		throw new Exception("parse error");
	}
}
