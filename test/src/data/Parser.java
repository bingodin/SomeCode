package data;

public class Parser {
	Lexer lexer;
	Token current_token;

	public Parser(Lexer lexer) throws Exception {
		this.lexer = lexer;
		this.current_token = lexer.get_next_token();
	}

	public void error() throws Exception {
			throw new Exception("��ʽ����ı��ʽ");
	}

	public AST term() throws Exception {
		AST node = factor();
		while (current_token.type == TokenType.DIV
				|| current_token.type == TokenType.MUL) {
			Token token = current_token;
			if (current_token.type == TokenType.MUL) {
				eat(TokenType.MUL);

			} else if (current_token.type == TokenType.DIV) {
				eat(TokenType.DIV);

			}
			return new BinAST(node, token, factor());
		}

		return node;

	}

	public AST factor() throws Exception {
		if (current_token.type == TokenType.INTEGER) {
			Token token = current_token;
			eat(TokenType.INTEGER);
			return new NumAST(token);
		} else if (current_token.type == TokenType.LPAREN) {
			eat(TokenType.LPAREN);
			AST node = expr();
			eat(TokenType.RPAREN);
			return node;
		}
		error();
		return null;
	}

	public AST expr() throws Exception {

		AST node = term();
		while (current_token.type == TokenType.PLUS
				|| current_token.type == TokenType.MINUS) {
			Token op = current_token;
			if (current_token.type == TokenType.PLUS) {
				eat(TokenType.PLUS);

			} else if (current_token.type == TokenType.MINUS) {
				eat(TokenType.MINUS);

			}
			node = new BinAST(node, op, term());
		}

		return node;

	}

	public void eat(TokenType type) throws Exception {
		if (this.current_token.type == type) {
			current_token = lexer.get_next_token();
			return;
		}
		error();
	}

	public AST parse() throws Exception {
		AST expr = expr();
		if(current_token.type!= TokenType.EOF){
			error();
		}
		return expr;
	}
}
