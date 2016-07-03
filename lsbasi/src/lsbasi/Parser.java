package lsbasi;

import lsbasi.ast.AST;
import lsbasi.ast.BinOpAST;
import lsbasi.ast.NumberAST;

public class Parser {
	private Lexer lexer;
	private Token currentToken;

	public Parser(Lexer lexer) throws Exception {
		this.lexer = lexer;
		currentToken = lexer.getNextToken();
	}

	public AST parser() throws Exception {
		AST expr = expr();
		eat(TokenType.EOF);
		return expr;

	}

	private AST expr() throws Exception {
		AST node = term();

		while (currentToken.type == TokenType.PLUS || currentToken.type == TokenType.MINUS) {
			Token token = currentToken;
			eat(token.type);
			AST right = term();
			node= new BinOpAST(node, token, right);
		}
		return node;
	}

	private AST term() throws Exception {
		AST node = factor();

		while (currentToken.type == TokenType.DIV || currentToken.type == TokenType.MULTI) {
			Token token = currentToken;
			eat(token.type);

			AST right = factor();
			node= new BinOpAST(node, token, right);
		}
		return node;
	}

	private AST factor() throws Exception {
		Token token = currentToken;
		if (token.type == TokenType.INTEGER) {

			eat(TokenType.INTEGER);
			return new NumberAST(Integer.parseInt(token.value));
		} else if (token.type == TokenType.LPAREN) {
			eat(TokenType.LPAREN);
			AST r = expr();
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
