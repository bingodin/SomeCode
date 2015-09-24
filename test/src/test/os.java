package test;

public class os {

	public static void main(String[] args) {
		print("ac\n\tbc\n\nss\nsss\naaaaaaaa\nssa");
		show();
	}

	/**
	 * 格式化字符串
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
					// java 用正则表达式做的 晕！
					// TODO
					// https://github.com/SamyPesse/How-to-Make-a-Computer-Operating-System/tree/master/Chapter-5
				}
			} else {
				putChar(ci);
			}

		}

	}

	// 回显
	static void show() {
		// 应该就上汇编了 写到某个地址就可以了
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(screen_buffer[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * 实现了字符的转意 输出char
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
			// 真正的赋值在c里面是一个指针
			screen_buffer[y][x] = c;
			x++;
			if (x > w - 1) {
				x = 0;
				y++;
			}
		}
		if (y > h - 1) {
			y = 0;
			// 暂时清空  很大c语音标准库的应用

			// 这里应该要保存 可能就是bash的功能了
			screen_buffer = new char[h][w];
		}

	}

	// 屏幕大小和数组
	static int h = 7;
	static int w = 40;
	static char[][] screen_buffer = new char[h][w];
	// 屏幕位置
	static int x = 0;
	static int y = 0;
}
