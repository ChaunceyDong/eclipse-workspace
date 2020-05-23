import java.util.Arrays;

public class CountingSortTest {

	public static void main(String[] args) {
		new CountingSortTest().testCountingSort();

		Stack s = new Stack(10);
		try {
			s.push(4);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			s.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void testCountingSort() {

		int[] a = new int[10];
		int[] b = new int[10];
		for (int i = 0; i < a.length; ++i) {
			a[i] = (int) (Math.random() * 10);
		}

		// System.out.println(Arrays.toString(b));

		System.out.println("Original");

		System.out.println(Arrays.toString(a));
		coutingSort(a, b);
		System.out.println("CountingSort");
		System.out.println(Arrays.toString(b));
	}

	void coutingSort(int[] a, int[] b) {
		int k = maxEle(a, a.length);

		int[] c = new int[k + 1];

		for (int i : a) {
			c[i]++;
		}
		System.out.println("Array c");
		System.out.println(Arrays.toString(c));
		for (int i = 1; i < c.length; ++i) {
			c[i] = c[i - 1] + c[i];
		}

		for (int i = a.length - 1; i >= 0; --i) {
			b[c[a[i]] - 1] = a[i];
			  c[a[i]]--;

		}
	}

	int maxEle(int[] a, int n) {
		// int max = a[a.length -1];
		if (n == 1)
			return a[0];
		return Math.max(maxEle(a, n - 1), a[n - 1]);

	}

}

class Stack {
	private int[] array;
	private int top;
	private int size;

	public Stack(int size) {
		this.size = size;
		array = new int[size];
		top = -1;

	}

	void push(int arg) throws Exception {
		// overflow
		if (isFull())
			throw new Exception("Overflow");
		else
			array[++top] = arg;
	}

	int pop() throws Exception {
		// underflow
		if (isEmpty())
			throw new Exception("Underflow");
		return array[top--];
	}

	boolean isEmpty() {
		return top == -1;
	}

	boolean isFull() {
		return top == size - 1;
	}

	void Print() {
		System.out.println(Arrays.toString(array));
	}

}