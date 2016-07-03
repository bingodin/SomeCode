package lsbasi;

import org.junit.Test;

public class TestLexer {

	@Test
	public void test1() throws Exception {
		Lexer lexer = new Lexer("{number=2;a=number;b=10*a+10;c=a--b};x=11;");
		Token nextToken = lexer.getNextToken();
		while (nextToken.type != TokenType.EOF) {
			System.out.println(nextToken);
			nextToken = lexer.getNextToken();
		}
	}
}
