import java.util.Arrays;

public class QuickSortTest {

	public static void main(String[] args) {
		new QuickSortTest().testQuicksort();
	}

	void testQuicksort() {
		int[] A = new int[20];
		for(int i=0; i < A.length; ++i) {
			A[i] = (int)(Math.random()*100);
		}
		
		
		System.out.println(Arrays.toString(A));
		quicksort(A, 0, A.length-1);
		System.out.println(Arrays.toString(A));
	}

	void quicksort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
	}

	int partition(int[] A, int p, int r) {
		int i = p - 1;
		int x = A[r];
		for (int j = p; j < r; ++j) {
			if (A[j] <= x) {
				++i;
				swap(A, i, j);
			}
		}
		swap(A, ++i, r);
		return i;
	}

	void swap(int[] A, int a, int b) {
		int s = A[a];
		A[a] = A[b];
		A[b] = s;
	}
}