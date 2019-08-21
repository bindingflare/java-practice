package day36.thread;

public class ThreadClass extends Thread {
	public String name;

	public ThreadClass(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("[ " + i + " ] " + name);

			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadClass thread1 = new ThreadClass("First");
		ThreadClass thread2 = new ThreadClass("Second");
		ThreadClass thread3 = new ThreadClass("Third");
		Thread thread4 = new Thread(new ThreadClass("Fourth"), "Thread-3");
		// Same as Thread thread4 = new Thread(new ThreadClass("Fourth"));

		thread2.setPriority(10);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		System.out.println(thread1.getPriority());
		System.out.println(thread2.getPriority());
	}
}
