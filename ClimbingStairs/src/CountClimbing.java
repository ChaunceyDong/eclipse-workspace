
public class CountClimbing {

	public static void main(String[] args) {

		new CountClimbing().test();
	}

	void test() {
		System.out.println(counting(10));
		System.out.println(counting_iteration(10));


	}

	int counting(int steps) {
		if (steps == 0)
			return 0;
		if (steps == 1)
			return 1;
		if (steps == 2)
			return 2;
		if (steps > 2)
			return counting(steps - 1) + counting(steps - 2);
		return 0;

	}
	
	int counting_iteration (int steps) {
		int sum[]  = new int[steps+1];
		sum[0] = 0;
		sum[1] = 1;
		sum[2] = 2;
		for(int i = 3; i <= steps; ++i) {
			sum[i] = sum[i-1] + sum[i-2];
		}
		return sum[steps];
	}
	

}