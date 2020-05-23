
public class HeapsortTest {

	public static int Heapsize; // global variable

	public static void main(String[] args) {
		new HeapsortTest().TestHeapSort();
	}

	void TestHeapSort() {

		int[] A = new int[20];
		for (int i = 0; i < A.length; ++i) {
			A[i] = (int) (Math.random() * 100);
		}

		System.out.println("The original array:");
		for (int i = 0; i < A.length; ++i) {
			System.out.print(A[i] + " ");
		}

		BuildHeap(A);
		System.out.println("\n"+"After Building_Heap");
		for (int i = 0; i < A.length; ++i) {
			System.out.print(A[i] + " ");
		}

		HeapSort(A);
		System.out.println("\n"+"After Heap_Sort");
		for (int i = 0; i < A.length; ++i) {
			System.out.print(A[i] + " ");
		}

	}

	void MaxHeapify(int[] A, int i) { // 若不加public private 默认包内可见
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;

		if (l < Heapsize && A[i] < A[l]) // 两个顺序不能变，若判断A大小，会出现l=lenth，溢出
			largest = l;

		if (r < Heapsize && A[largest] < A[r])
			largest = r;

		if (largest != i) {
			swap(A, largest, i);
			MaxHeapify(A, largest);
		}
	}

	void swap(int[] A, int a, int b) {
		int swap = A[b];
		A[b] = A[a];
		A[a] = swap;
	}

	void BuildHeap(int[] A) {
		Heapsize = A.length;
		for (int i = Heapsize / 2 - 1; i >= 0; --i) {
			MaxHeapify(A, i);
		}
	}
	// 0 1 2 3 4
//	void HeapSort(int[] A) {
//		BuildHeap(A);
//		for (int i = A.length; i > 0; --i) {
//			swap(A, 0, i-1);
//			--Heapsize;
//			MaxHeapify(A, 0);
//		}
//
//	}
	void HeapSort(int[] A) {
		BuildHeap(A);
		for (; Heapsize > 1;) {
			swap(A, 0, --Heapsize);
			MaxHeapify(A, 0);
		}

	}
	
}
