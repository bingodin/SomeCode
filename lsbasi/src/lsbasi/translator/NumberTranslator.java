package lsbasi.translator;

import lsbasi.ast.NumberAST;

public class NumberTranslator {
	public static String translatPostfix(NumberAST node) {
		return String.valueOf(node.val);
	}

	public static String translatLISPtyle(NumberAST node) {
		return String.valueOf(node.val);
	}
}
