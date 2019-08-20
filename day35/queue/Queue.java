package day35.queue;

public class Queue {
	private Node<?> startNode;
	private final int QUEUE_SIZE;
	private int currIndex = 0;

	public Queue(int size) {
		QUEUE_SIZE = size;
	}

	public boolean isEmpty() {
		return startNode == null;
	}

	public <T> boolean enqueue(T value) {
		Node<T> newNode = new Node<>(value);

		if (isEmpty()) {
			startNode = newNode;
		} else if (QUEUE_SIZE == currIndex) {
			return false;
		} else {
			Node<?> currentNode = startNode;
			
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			
			currentNode.setNext(newNode);
		}
		
		currIndex++;

		return true;
	}

	public Object dequeue() {
		if(isEmpty()) {
			return null;
		}
		
		Node<?> outNode = startNode;
		startNode = startNode.getNext();
		
		currIndex--;

		return outNode.getValue();
	}

	public void print() {
		System.out.print("[ ");
		
		Node<?> currentNode = startNode;

		if (isEmpty()) {
			System.out.print("(+ " + QUEUE_SIZE + " empty slots)");
		} else {
			System.out.print(currentNode.getValue());

			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
				
				System.out.print(", " + currentNode.getValue());
			}

			System.out.print(" (+" + (QUEUE_SIZE - currIndex) + " empty slots)");
		}

		System.out.print(" ]");
		System.out.println();
	}
}
