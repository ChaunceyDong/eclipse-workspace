import java.util.Arrays;

public class findMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[20] ;

		for ( int j=0 ; j<20 ; j++) {
			a[j] = (int)(Math.random()*100);
		}
		System.out.println(Arrays.toString(a));

		System.out.println(max(a,0,19));
	}
	
	static int max(int[] a, int i, int j) {
		if(i == j)
			return a[i];	
		return Math.max(a[i], max(a,i+1,j));
	}
	
	int maxEle(int[] a, int n) {
		if (n == 1)
			return a[0];
		return Math.max(maxEle(a, n - 1), a[n - 1]);

	}
}

