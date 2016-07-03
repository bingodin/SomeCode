package lsbasi.ast;

import lsbasi.Token;

public class BinOpAST implements AST {
	public AST left;
	public AST right;
	public Token op;

	public BinOpAST(AST left, Token token, AST right) {
		this.left = left;
		this.op = token;
		this.right = right;
	}
}
