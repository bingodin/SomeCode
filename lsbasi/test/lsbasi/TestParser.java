package lsbasi;

import java.util.List;

import org.junit.Test;

import lsbasi.ast.StatementAST;
import lsbasi.ast.StatementListAST;

public class TestParser {
	@Test
	public void test1() throws Exception {
		Lexer lexer = new Lexer("{number=2;a=number;b=10*a+10;c=a--b};x=11;");
		Parser p = new Parser(lexer);
		StatementListAST a = p.parser();
		List<StatementAST> list = a.getList();
		for (StatementAST statementAST : list) {
			System.out.println(statementAST);
		}
	}
}
