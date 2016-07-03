package lsbasi.visit;

import lsbasi.ast.NumberAST;

public class NumberVisitor {
	public static int visit(NumberAST node) {
		return node.val;
	}
}
