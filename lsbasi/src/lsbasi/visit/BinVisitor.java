package lsbasi.visit;

import lsbasi.Token;
import lsbasi.TokenType;
import lsbasi.ast.BinOpAST;

public class BinVisitor {
	public static int visit(BinOpAST node) throws Exception {
		Token op = node.op;
		
		int left = NodeVisitor.visit(node.left);
		int right = NodeVisitor.visit(node.right);
		if (op.getType() == TokenType.PLUS) {
			return left + right;
		} else if (op.getType() == TokenType.MINUS) {
			return left - right;
		} else if (op.getType() == TokenType.MULTI) {
			return left * right;
		} else {
			return left / right;
		}

	}
}
