package lsbasi;

import org.junit.Assert;
import org.junit.Test;

public class TestInter {

	@Test
	public void test1() throws Exception {
		Interpreter i = new Interpreter(new Parser(new Lexer("1*1+1+2+(2*2)")));
		int r = i.eval();
		Assert.assertEquals(r, 8);

	}

}
