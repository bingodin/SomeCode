package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
/**
 * 测试io和多线程 统计文件中的数字求和
 * @author Administrator
 *
 */
public class TestIOAndThreads {
	static String dirPath = "f:/Test/";

	public static void main(String[] args) throws IOException {
		// sum1();

		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(sumOneThread());
		long oneThreadSumTimeCost = System.currentTimeMillis()
				- currentTimeMillis;
		System.out.println(oneThreadSumTimeCost);

		System.out.println("-----------------------");
		currentTimeMillis = System.currentTimeMillis();
		System.out.println(sumMtuilThreads());
		long moreThreadSumTimeCost = System.currentTimeMillis()
				- currentTimeMillis;
		System.out.println(moreThreadSumTimeCost);
		// io型瓶颈 ，反而单线程更快
		System.out.print(oneThreadSumTimeCost < moreThreadSumTimeCost ? "单"
				: "多");
		System.out.println("线程更快");
	}

	@Test
	//生成100个测试文件
	public void createFile() throws IOException {

		for (int i = 0; i < 100; i++) {
			File file = new File(dirPath + i);
			FileOutputStream f = new FileOutputStream(file);
			wirteIntTofile(f);
			// file.delete();
			f.close();
		}
	}

	/**
	 * 向文件输入流内写100 000个100内的随机整数
	 * 
	 * @param f
	 * @throws IOException
	 */
	static void wirteIntTofile(FileOutputStream f) throws IOException {
		String str = "";
		for (int i = 0; i < 100000; i++) {
			str += Math.round(Math.random() * 100) + ";";
		}
		str += Math.round(Math.random() * 100);
		byte[] b = (str).getBytes();
		f.write(b);
	}

	/**
	 * 多线程读取文件求和
	 * 
	 * @return
	 * @throws IOException
	 */
	public static int sumMtuilThreads() throws IOException {
		int howmanyThread = 100;
		ReadThread threads[] = new ReadThread[howmanyThread];
		for (int i = 0; i < howmanyThread; i++) {
			threads[i] = new ReadThread(i);
			threads[i].start();
		}
		int sum=0;
		for (int i = 0; i < howmanyThread; i++) {
			try {
				threads[i].join();
				sum+=threads[i].sumNotStatic;
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
//		return ReadThread.sum / 100000 / howmanyThread;
		return sum / 100000 / howmanyThread;
	}

	/**
	 * 一个显示读取求和
	 * 
	 * @return
	 * @throws IOException
	 */
	public static int sumOneThread() throws IOException {
		int sum = 0;
		int howmanyThread = 100;
		for (int i = 0; i < howmanyThread; i++) {
			File file = new File(TestIOAndThreads.dirPath + i);
			FileInputStream f;
			try {
				f = new FileInputStream(file);
				StringBuffer stringBuffer = new StringBuffer();
				byte[] b = new byte[512];
				int n = 0;// 实际读取到的字节数
				// 循环读取
				while ((n = f.read(b)) != -1) {
					stringBuffer.append(new String(b, 0, n));
				}
				f.close();

				String stringIntformFIle = stringBuffer.toString();
				String[] splitIntArry = stringIntformFIle.split(";");
				for (String stringInt : splitIntArry) {
					sum += (Integer.parseInt(stringInt));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return sum / 100000 / howmanyThread;
	}
}

class ReadThread extends Thread {
	int i;
	public static int sum = 0;
	public int sumNotStatic=0;

	public ReadThread(int i) {
		this.i = i;
	}

	static synchronized void inc(int i) {
		sum += i;
	}

	 void sumNotStatic(int i) {
		 sumNotStatic += i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		File file = new File(TestIOAndThreads.dirPath + i);
		FileInputStream f;
		try {
			f = new FileInputStream(file);
			StringBuffer stringBuffer = new StringBuffer();
			byte[] b = new byte[512];
			int n = 0;// 实际读取到的字节数
			// 循环读取
			while ((n = f.read(b)) != -1) {
				stringBuffer.append(new String(b, 0, n));
			}
			f.close();

			String stringIntformFIle = stringBuffer.toString();
			String[] splitIntArry = stringIntformFIle.split(";");
//			for (String stringInt : splitIntArry) {
//				inc(Integer.parseInt(stringInt));//过度的并行
//			}
			for (String stringInt : splitIntArry) {
				sumNotStatic(Integer.parseInt(stringInt));//划分
			}
			// System.out.println(sum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
