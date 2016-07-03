package lsbasi.translator;

import lsbasi.ast.AST;
import lsbasi.ast.BinOpAST;
import lsbasi.ast.NumberAST;

public class Translator {
	public static String translatPostfix(AST node) throws Exception {
		if (node instanceof NumberAST) {
			return NumberTranslator.translatPostfix((NumberAST) node);
		} else if (node instanceof BinOpAST) {
			return BinTranslator.translatPostfix((BinOpAST) node);
		}
		throw new Exception("error");
	}

	public static String translatLISPtyle(AST node) throws Exception {
		if (node instanceof NumberAST) {
			return NumberTranslator.translatLISPtyle((NumberAST) node);
		} else if (node instanceof BinOpAST) {
			return BinTranslator.translatLISPtyle((BinOpAST) node);
		}
		throw new Exception("error");
	}
}
