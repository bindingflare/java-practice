package day34.myarray_generics;

public class MyArray<T> {
	T element;
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public T getElement() {
		return element;
	}
}
