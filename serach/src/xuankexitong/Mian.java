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
			System.out.println("0:	�鿴");
			System.out.println("1:	ɾ��");
			System.out.println("2:	����");
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
				System.out.println("�˳��ˣ���");
				return;
			default:
				System.out.println("ѡ�����ޣ���");
				break;
			}
		}
	}

	private static void view() {
		// TODO Auto-generated method stub
		System.out.println("���µ�����-------");
		News.serach("");
		System.out.println("-------------");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("�������ݣ���������,(����qqq�˳�)");
			String snext = s.next();
			if ("qqq".equals(snext))
				return;
			System.out.println("����������-------");
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
