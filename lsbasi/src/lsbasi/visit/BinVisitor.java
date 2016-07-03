package lsbasi.visit;

import java.util.Map;

import lsbasi.Token;
import lsbasi.TokenType;
import lsbasi.ast.BinOpAST;

public class BinVisitor {
	public static int visit(BinOpAST node, Map<String, Integer> scope) throws Exception {
		Token op = node.op;

		int left = NodeVisitor.visit(node.left, scope);
		int right = NodeVisitor.visit(node.right, scope);
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
