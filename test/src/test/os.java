package test;

public class os {

	public static void main(String[] args) {
		print("ac\n\tbc\n\nss\nsss\naaaaaaaa\nssa");
		show();
	}

	/**
	 * ��ʽ���ַ���
	 * 
	 * @param format
	 * @param args
	 */
	static void print(String format, Object... args) {
		for (int i = 0; i < format.length(); i++) {
			char ci = format.charAt(i);
			if (ci == '%') {
				ci = format.charAt(++i);
				if (ci >= '0' && ci <= '9') {
					int size = ci - '0';
					ci = format.charAt(++i);
				}

				if (ci == 'd') {
					// java ��������ʽ���� �Σ�
					// TODO
					// https://github.com/SamyPesse/How-to-Make-a-Computer-Operating-System/tree/master/Chapter-5
				}
			} else {
				putChar(ci);
			}

		}

	}

	// ����
	static void show() {
		// Ӧ�þ��ϻ���� д��ĳ����ַ�Ϳ�����
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(screen_buffer[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * ʵ�����ַ���ת�� ���char
	 * 
	 * @param c
	 */
	static void putChar(char c) {

		if (c == '\n') {
			x = 0;
			y++;
			// back space
		} else if (c == '\b') {
			if (x > 0) {

				x--;
			}
			// horizontal tab
		} else if (c == '\t') {
			x = x + 8 - (x % 8);
			// carriage return
		} else if (c == '\r') {
			x = 0;
		} else {
			// �����ĸ�ֵ��c������һ��ָ��
			screen_buffer[y][x] = c;
			x++;
			if (x > w - 1) {
				x = 0;
				y++;
			}
		}
		if (y > h - 1) {
			y = 0;
			// ��ʱ���  �ܴ�c������׼���Ӧ��

			// ����Ӧ��Ҫ���� ���ܾ���bash�Ĺ�����
			screen_buffer = new char[h][w];
		}

	}

	// ��Ļ��С������
	static int h = 7;
	static int w = 40;
	static char[][] screen_buffer = new char[h][w];
	// ��Ļλ��
	static int x = 0;
	static int y = 0;
}
