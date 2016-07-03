package lsbasi.visit;

import java.util.Map;

import lsbasi.ast.AssignmentAST;

public class AssignVisitor {
	public static void visit(AssignmentAST node, Map<String, Integer> scope) throws Exception {

		scope.put(node.getId(), NodeVisitor.visit(node.getExpr(), scope));

	}
}
