import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class ArrayStack<T> {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayStack<Integer> stack = new ArrayStack<Integer>(n);
		// You code here
	}

	// Your code here
	Object[] data;
	int lastIndex = 0;

	public ArrayStack(int capacity) {
		data = new Object[capacity];
	}

	public int count() {
		// Your code here
		return 0;
	}

	/**
	 * @description: add item when stack is not full
	 */
	public void push(T item) {
		// Sample: data[lastIndex++] = item;
		// Your code here
	}

	/**
	 * @return: return and remove top item, or null when stack is empty
	 */
	public T pop() {
		// Your code here
		return null;
	}

	/**
	 * @return: return top item, or null when stack is empty
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		// Sample return (T) data[lastIndex - 1];
		// Your code here
		return null;
	}
}
