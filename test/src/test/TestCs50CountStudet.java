package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;


import org.junit.Test;
/**
 * 分布式的统计学生数量
 * @author Administrator
 *
 */
public class TestCs50CountStudet {

	@Test
	public void countStudet() {

		HashSet<Seat> seats = initSeats();

		long currentTimeMillis = System.currentTimeMillis();
		for (Studet s : Studet.allStudets) {
			s.start();
		}
		int sum =0;
		for (Studet s : Studet.allStudets) {//or Studet.standStudets ？//? 
			try {
				s.join();
				if(!s.hasCount)
				sum+=s.cur;
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		long timeCost = System.currentTimeMillis() - currentTimeMillis;
		System.out.println(timeCost+"ms");
//		System.out.println(Studet.sum + "-");
		System.out.println(sum);
		// int sum = oneThreadCount(seats);
		// System.out.println(sum+":");

	}

	private int oneThreadCount(HashSet<Seat> seats) {
		int howManystudets = 0;
		Iterator<Seat> iterator = seats.iterator();
		for (; iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			if (seat.hasStudet) {
				howManystudets++;
			}
			try {
				Thread.sleep(10);//如果顺序执行有更大的延迟
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		return howManystudets;
	}

	private HashSet<Seat> initSeats() {
		HashSet<Seat> seats = new HashSet<>();
		Vector<Studet> Studets = new Vector<Studet>();
		for (int i = 0; i < Seat.howManySeats; i++) {
			Seat seat = new Seat();
			if (Math.random() > 0.5) {
				seat.hasStudet = true;
				Studets.add(new Studet(Studets.size()));
			}
			seats.add(seat);
		}
		Studet.standStudets = Studets;
		Studet[] array = Studets.toArray(new Studet[Studets.size()]);
		Studet.allStudets = array;
		return seats;
	}

}

class Studet extends Thread {
	boolean hasCount = false;
	int number;
	int cur = 1;
	public static int sum = 0;
	public static Studet[] allStudets;
	public static Vector<Studet> standStudets;
	public static boolean over = false;
	public static Studet old = null;

	public Studet(int number) {
		this.number = number;

	}

	public String toString() {
		return "a" + number + ":";
	}

	void inc() {

		if (standStudets.size() > 1) {
			Studet s;

			int index = (int) (Math.random() * Seat.howManySeats)
					% standStudets.size();

			s = standStudets.get(index);

			if (s != this) {
				System.out.println(this + "i am " + cur + " you are " + s
						+ s.cur);
				cur += s.cur;

				s.hasCount = true;
				standStudets.remove(s);
				System.out.println("we are " + cur);
			}

		} else {

			over = true;

			sum = cur;

		}
	}

	public void run() {
		super.run();
		System.out.println(this + "i am " + cur);
		synchronized (getClass()) {//锁的对象是类   这里应该也许该重写
			
			

			while (!hasCount && !over) {
				inc();
			}
		}

	}
}

class Seat {
	public static int howManySeats = 100;
	boolean hasStudet = false;
}
