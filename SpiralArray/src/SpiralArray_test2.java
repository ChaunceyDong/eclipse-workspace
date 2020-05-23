import java.util.Scanner;

public class SpiralArray_test2 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Spiral Array Generator!");
		SpiralArray_test2 obj = new SpiralArray_test2();
		obj.play();
	}

	public void play() {

		System.out.println("What dimension would you like");
		Scanner scan = new Scanner(System.in);
		while (true) {
			int input = scan.nextInt();
			if (input >= 1) {
				new Spiral(input);
				break;
			}
			System.out.println("Please enter an integer greater than or equal to 1.How many rows do you want?");
		}

		System.out.println("Do you want to generate another Spiral Array?");

		while (true) {
			String input2 = scan.next();
			if (input2.equals("y")) {
				play();
				break;
			} else if (input2.equals("n")) {
				System.out.println("Thank you for using the Spiral Array Generator!");
				break;
			}

			else {
				System.out.println("ERROR: input only 'y' or 'n'.");
				continue;
			}
		}

		scan.close();
	}
}

class Spiral {

	public Spiral(int N) {
		int[][] a = new int[N][N];

		// 先建立一个二维数组

		// 为了观察运行出的错，先把数组各个元素通通赋为0吧，这样一来，有什么错误在运行时候，一看就能看出来。
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				a[i][j] = 0;
			}

		// 试了一下从1赋值，感觉很费事，还是从后往前推吧，最后一个数字是N*N
		int last = 1;
		int n = N; // 中间变量。
		int i = 0, j;// 第一个循环要用到i(第54行)，所以赋个初值

		for (int count = 0; count < N / 2; count++)// 如果把一圈当作一个循环的话，那整体循环N/2次
		{
			for (j = count; j < n - 1; j++)
				a[i][j] = last++;
			for (i = count; i < n - 1; i++)
				a[i][j] = last++;
			for (; j > count; j--)
				a[i][j] = last++;
			for (; i > count; i--)
				a[i][j] = last++;
			// 最外面的一圈赋值完成了，进行下一圈。
			n--;
			i++;
		}

		if (N % 2 != 0) {
			int b = (N - 1) / 2;
			a[b][b] = N * N;
		}

		// 显示数组各个元素
		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = 0; j1 < N; j1++) {
				System.out.print(a[i1][j1] + "\t");
				if (j1 == N - 1) // 这要注意换行。
					System.out.println("");

			}
		}
	}

}