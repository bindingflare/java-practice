package day34.queue;

public class Queue<T> {
	private T[] arr;
	private int currIndex;
	
	@SuppressWarnings("unchecked")
	public Queue(int size) {
		arr = (T[]) new Object[size];
	}
	
	public boolean isEmpty() {
		return currIndex == 0;
	}
	
	public boolean enqueue(T element) {
		return true;
	}
	
	private void shiftRight() {
		
	}
	
	private void shiftLeft() {
		
	}
	
}
