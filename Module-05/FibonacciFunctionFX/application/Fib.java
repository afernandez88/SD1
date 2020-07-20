package application;

// Object class for a "Fib"
public class Fib {

	long num;
	long time;

	public Fib(long num, long time) {
		super();
		this.num = num;
		this.time = time;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return num + " in " + time + "ns";
	}

} // end Fib
