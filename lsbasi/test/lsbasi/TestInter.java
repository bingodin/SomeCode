package lsbasi;

import org.junit.Assert;
import org.junit.Test;

import lsbasi.ast.StatementListAST;

public class TestInter {
	@Test
	public void test() throws Exception {
		Lexer lexer = new Lexer("{number=2;a=number;b=10*a+10;c=a--b};x=11;");
		Parser p = new Parser(lexer);

		Interpreter i = new Interpreter(p);
		i.run();
		System.out.println(i.GLOBAL_SCOPE);

	}
}
