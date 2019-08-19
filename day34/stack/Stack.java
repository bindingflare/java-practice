package day34.stack;

import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> arr;
	private int limit;

	public Stack(int size) {
		arr = new ArrayList<>();
		limit = size;
	}

	public void push(T element) {
		if (arr.size() == limit) {
		} else {
			arr.add(element);
		}
	}

	public T pop() {
		if (arr.size() == 0) {
			return null;
		}

		T element = arr.get(arr.size() - 1);
		arr.remove(arr.size() - 1);
		return element;
	}

	public boolean isEmpty() {
		return arr.size() == 0;
	}

	public void print() {
		System.out.println("Stack: ");
		
		for (T element : arr) {
			System.out.print(element + " ");
		}
		
		System.out.println();
	}
}
