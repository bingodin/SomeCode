package xuankexitong;

import java.util.Scanner;

public class Mian {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Messages.getString("Mian.0")); //$NON-NLS-1$
		login();
		commd();
		Thread.sleep(1000);
	}

	private static void commd() {
		while (true) {
			System.out.println(Messages.getString("Mian.1")); //$NON-NLS-1
			System.out.println("0:	查看");
			System.out.println("1:	删除");
			System.out.println("2:	增加");
			System.out.println("3:	exit");
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			String bi = s.next();
			int i = 5;
			try {

				i = Integer.parseInt(bi);
			} catch (NumberFormatException e) {
			} finally {
			}
			switch (i) {
			case 0:
				view();
				break;
			case 1:

				break;
			case 2:

				break;
			case 3:
				System.out.println("退出了！！");
				return;
			default:
				System.out.println("选择有限！！");
				break;
			}
		}
	}

	private static void view() {
		// TODO Auto-generated method stub
		System.out.println("最新的新闻-------");
		News.serach("");
		System.out.println("-------------");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("输入内容，搜索新闻,(输入qqq退出)");
			String snext = s.next();
			if ("qqq".equals(snext))
				return;
			System.out.println("你的搜索结果-------");
			News.serach(snext);
			System.out.println("--------------");
		}
	}

	@SuppressWarnings("resource")
	public static void login() {
		Scanner s = new Scanner(System.in);
		String name, pass;
		while (true) {
			System.out.println(Messages.getString("Mian.2")); //$NON-NLS-1$
			name = s.next();
			System.out.println(Messages.getString("Mian.3")); //$NON-NLS-1$
			pass = s.next();
			if (User.check(name, pass)) { //$NON-NLS-1$ //$NON-NLS-2$
				return;
			} else {
				System.out.println(Messages.getString("Mian.6")); //$NON-NLS-1$
			}
		}

	}
}
