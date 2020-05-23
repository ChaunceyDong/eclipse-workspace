
public class MergeSort {

	public static void main(String[] args) {

		MergeSort ms = new MergeSort();

		int[] A = new int[30];

		for (int i = 0; i < A.length; ++i) {
			A[i] = (int) (Math.random() * 100);
			System.out.print(A[i] + " ");
		}
		System.out.println();
		ms.MergeSortTest(A, 0, A.length-1);

		for (int i = 0; i < A.length; ++i) {
			System.out.print(A[i] + " ");
		}

	}

	void MergeSortTest(int[] A, int p, int r) {
		int q = (p + r) / 2;
		if (p < r) {
			MergeSortTest(A, p, q);
			MergeSortTest(A, q + 1, r);
			Merge(A, p, q, r);
		}
	}

	void Merge(int[] A, int p, int q, int r) {
		int lsize = q - p + 1;
		int rsize = r - q;
		int[] L = new int[lsize+1];
		int[] R = new int[rsize+1];

		for (int i = p; i <= q; ++i) {
			L[i - p] = A[i];
		}
		L[lsize ] = Integer.MAX_VALUE;

		for (int i = q + 1; i <= r; ++i) {
			R[i - q - 1] = A[i];
		}
		R[rsize ] = Integer.MAX_VALUE;
 
		int i = 0;
		int j = 0;

		for (int k = p; k <= r; ++k) {
			if (L[i] < R[j]) {
				A[k] = L[i];
				++i;
			} 
			
			else {
				A[k] = R[j];
				++j;
			}
		}

	}

}
