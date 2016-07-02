package lsbasi;

import org.junit.Assert;
import org.junit.Test;

public class Part2 {

	@Test
	public void test1() throws Exception{
		Interpreter i = new Interpreter("1+1");
		int r = i.expr();
		Assert.assertEquals(r, 2);
		
	}
	@Test
	public void test2() throws Exception{
		Interpreter i = new Interpreter("112-110");
		int r = i.expr();
		Assert.assertEquals(r, 2);
		
	}
	@Test
	public void test3() throws Exception{
		Interpreter i = new Interpreter("1*2");
		int r = i.expr();
		Assert.assertEquals(r, 2);
		
	}
	@Test
	public void test4() throws Exception{
		Interpreter i = new Interpreter("4/2");
		int r = i.expr();
		Assert.assertEquals(r, 2);
		
	}
	@Test
	public void test5() throws Exception{
		Interpreter i = new Interpreter("3-1+10-10");
		int r = i.expr();
		Assert.assertEquals(r, 2);
		
	}
}
