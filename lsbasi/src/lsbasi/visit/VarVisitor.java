package lsbasi.visit;

import java.util.Map;

import lsbasi.ast.VarAST;

public class VarVisitor {
	public static int visit(VarAST node, Map<String, Integer> scope) throws Exception {
		Integer integer = scope.get(node.id);
		if (integer != null) {
			return integer;
		}
		throw new Exception(node.id + "is undefined");
	}
}
