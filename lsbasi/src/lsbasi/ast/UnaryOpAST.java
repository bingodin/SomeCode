package lsbasi.ast;

import lsbasi.Token;

public class UnaryOpAST implements AST {
	private Token op;
	private AST valNode;

	public Token getOp() {
		return op;
	}

	public AST getValNode() {
		return valNode;
	}

	public UnaryOpAST(Token op, AST valNode) {
		this.op = op;
		this.valNode = valNode;
	}

}
