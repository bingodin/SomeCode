package lsbasi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("lsbasi");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print(">");
			String str = s.nextLine();
			Interpreter i = new Interpreter(new Lexer(str));
			int r = i.expr();
			System.out.println(r);
		}
	}

}
