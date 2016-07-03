package lsbasi;

import lsbasi.ast.AST;
import lsbasi.ast.AssignmentAST;
import lsbasi.ast.BinOpAST;
import lsbasi.ast.NopoAST;
import lsbasi.ast.NumberAST;
import lsbasi.ast.StatementAST;
import lsbasi.ast.StatementListAST;
import lsbasi.ast.UnaryOpAST;
import lsbasi.ast.VarAST;

public class Parser {
	private Lexer lexer;
	private Token currentToken;

	public Parser(Lexer lexer) throws Exception {
		this.lexer = lexer;
		currentToken = lexer.getNextToken();
	}

	public StatementListAST parser() throws Exception {
		StatementListAST expr = program();
		eat(TokenType.EOF);
		return expr;

	}

	StatementListAST program() throws Exception {
		StatementListAST node = statementList();
		return node;
	}

	private StatementListAST statementList() throws Exception {
		StatementListAST list = new StatementListAST(statement());
		while (currentToken.type == TokenType.SEMI) {
			if (currentToken.type == TokenType.SEMI) {
				eat(TokenType.SEMI);
			}
			list.add(statement());
		}
		return list;
	}

	private StatementAST statement() throws Exception {
		StatementAST node;
		if (currentToken.type == TokenType.BEGIN) {
			eat(TokenType.BEGIN);
			StatementAST statementList = statementList();
			eat(TokenType.END);
			node = statementList;
		} else if (currentToken.type == TokenType.ID) {
			node = assignmentStatement();
		} else {
			node = new NopoAST();
		}

		return node;
	}

	private StatementAST assignmentStatement() throws Exception {
		Token token = currentToken;
		eat(TokenType.ID);
		eat(TokenType.ASSIGN);
		AST expr = expr();

		return new AssignmentAST(token.value, expr);
	}

	private AST expr() throws Exception {
		AST node = term();

		while (currentToken.type == TokenType.PLUS || currentToken.type == TokenType.MINUS) {
			Token token = currentToken;
			eat(token.type);
			AST right = term();
			node = new BinOpAST(node, token, right);
		}
		return node;
	}

	private AST term() throws Exception {
		AST node = factor();

		while (currentToken.type == TokenType.DIV || currentToken.type == TokenType.MULTI) {
			Token token = currentToken;
			eat(token.type);

			AST right = factor();
			node = new BinOpAST(node, token, right);
		}
		return node;
	}

	private AST factor() throws Exception {
		Token token = currentToken;
		if (token.type == TokenType.PLUS || token.type == TokenType.MINUS) {

			eat(token.type);
			return new UnaryOpAST(token, factor());
		} else if (token.type == TokenType.INTEGER) {

			eat(TokenType.INTEGER);
			return new NumberAST(Integer.parseInt(token.value));
		} else if (token.type == TokenType.LPAREN) {
			eat(TokenType.LPAREN);
			AST r = expr();
			eat(TokenType.RLPAREN);
			return r;
		} else if (token.type == TokenType.ID) {

			return variable();
		}
		throw new Exception("parse error");
	}

	AST variable() throws Exception {
		VarAST varAST = new VarAST(currentToken.getValue());
		eat(TokenType.ID);
		return varAST;
	}

	private void eat(TokenType type) throws Exception {
		if (currentToken.type == type) {

			currentToken = lexer.getNextToken();
			return;
		}
		throw new Exception("parse error");
	}
}
