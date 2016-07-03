package lsbasi.visit;

import lsbasi.Token;
import lsbasi.TokenType;
import lsbasi.ast.UnaryOpAST;

public class UnaryVisitor {

	public static int visit(UnaryOpAST node) throws Exception {
		Token op = node.getOp();
		if (op.getType() == TokenType.PLUS) {
			return NodeVisitor.visit(node.getValNode());
		} else {
			return 0 - NodeVisitor.visit(node.getValNode());
		}

	}

}
