package day34.stack;

public class StackV2<T> {
	private T[] arr;
	private int currIndex = 0;

	@SuppressWarnings("unchecked")
	public StackV2(int size) {
		arr = (T[]) new Object[size];
	}

	public boolean isEmpty() {
		return currIndex == 0;
	}

	public boolean push(T element) {
		if (currIndex == arr.length) {
			return false;
		}

		arr[currIndex] = element;
		currIndex++;

		return true;
	}

	public T pop() {
		if (isEmpty()) {
			return null;
		}

		currIndex--;

		T element = arr[currIndex];
		arr[currIndex] = null;

		return element;
	}

	public void print() {
		System.out.print("[ ");

		if (isEmpty()) {
			System.out.print("(+ " + arr.length + " empty slots)");
		} else {
			System.out.print(arr[0]);
			
			for (int i = 1; i < currIndex; i++) {
				System.out.print(", " + arr[i]);
			}
			
			System.out.print(" (+" + (arr.length - currIndex) + " empty slots)");
		}

		System.out.print(" ]");
		System.out.println();
	}
}
