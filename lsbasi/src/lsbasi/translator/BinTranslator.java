package lsbasi.translator;

import lsbasi.Token;
import lsbasi.ast.BinOpAST;

public class BinTranslator {
	public static String translatPostfix(BinOpAST node) throws Exception {
		Token op = node.op;
		String left = Translator.translatPostfix(node.left);
		String right = Translator.translatPostfix(node.right);
		return String.format("%s %s %s", left, right, op.getValue());

	}

	public static String translatLISPtyle(BinOpAST node) throws Exception {
		Token op = node.op;
		String left = Translator.translatLISPtyle(node.left);
		String right = Translator.translatLISPtyle(node.right);
		return String.format("(%s %s %s)", op.getValue(), left, right);

	}

}
