package lsbasi.visit;

import java.util.Map;

import lsbasi.Token;
import lsbasi.TokenType;
import lsbasi.ast.UnaryOpAST;

public class UnaryVisitor {

	public static int visit(UnaryOpAST node, Map<String, Integer> scope) throws Exception {
		Token op = node.getOp();
		if (op.getType() == TokenType.PLUS) {
			return NodeVisitor.visit(node.getValNode(), scope);
		} else {
			return 0 - NodeVisitor.visit(node.getValNode(), scope);
		}

	}

}
