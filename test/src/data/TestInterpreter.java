package data;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class TestInterpreter {
	@Test
	public void test() throws Exception {
		Lexer lexer = new Lexer("(1*(2+1))");
		int r = new Interpreter(lexer).expr();
		System.out.println(r);
		assertEquals(r, 3);

	}

	@Test
	public void test1() throws Exception {
		Lexer lexer = new Lexer("1*2+1*2*1+1-1");
		int r = new Interpreter(lexer).expr();
		System.out.println(r);
		assertEquals(r, 4);

	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("输入表达式,如：1+2");
			try {

				String text = sc.next();

				Lexer lexer = new Lexer(text);
				Interpreter interpreter = new Interpreter(lexer);
				int result = interpreter.expr();
				print(result);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private static void print(int r) {
		System.out.println(r);

	}
}
