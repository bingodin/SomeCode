package lsbasi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("lsbasi");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println(">");
			String str = s.nextLine();
			Interpreter i = new Interpreter(str);
			int r = i.expr();
			System.out.println(r);
		}
	}

}
