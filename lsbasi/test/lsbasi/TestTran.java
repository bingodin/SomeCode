package lsbasi;

import org.junit.Test;

import lsbasi.ast.AST;
import lsbasi.translator.Translator;

public class TestTran {
	@Test
	public void test1() throws Exception {
		AST node = new Parser(new Lexer("1+2*3")).parser();

		String translatPostfix = Translator.translatPostfix(node);

		System.out.println(translatPostfix);

		String translatLISPtyle = Translator.translatLISPtyle(node);

		System.out.println(translatLISPtyle);

	}

}
