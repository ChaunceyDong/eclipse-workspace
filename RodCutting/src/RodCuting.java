
public class RodCuting {

	public static void main(String[] args) {

		new RodCuting().task();
	}

	void task() {
		int[] p = new int[] { 1, 5, 8, 9, 10, 17, 17, 20, 24, 40 };
		rodCut_topdown(p, 4);
		for (int i = 0; i <= 10; i++) {
			System.out.println("r = "+i + "ʱ");
			System.out.println("TopDown Algorithm "+rodCut_topdown(p, i));
			System.out.println("DownTop Algorithm "+rodCut_downtop(p, i)+ "\n");
		}
	}

	int rodCut_topdown(int[] p, int n) {
		if (n == 0)
			return 0;
		int q = -Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) { // i: 0 -> n-1
			q = Math.max(q, p[i] + rodCut_topdown(p, n - 1 - i));
		}
		return q;
	}

	int rodCut_downtop(int[] p, int n) {
		int[] r = new int[n + 1];
		r[0] = 0;
		for (int i = 1; i <= n; i++) {
			int q = -Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				q = Math.max(q, p[j] + r[i - j - 1]);
			}
			r[i] = q;
		}
		return r[n];

	}

}
