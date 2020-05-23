import java.util.Scanner;

public class SpiralArray_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner (System.in);
		int N = scan.nextInt();
		scan.close();

		// 先建立一个二维数组
		int[][] a = new int[N][N];

		// 为了观察运行出的错，先把数组各个元素通通赋为0吧，这样一来，有什么错误在运行时候，一看就能看出来。
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				a[i][j] = 0;
			}

		// 试了一下从1赋值，感觉很费事，还是从后往前推吧，最后一个数字是N*N
		int last = N * N;
		int n = N; // 中间变量。
		int i = n - 1, j;// 第一个循环要用到i（28行），所以赋个初值
		for (int k = 0; k < N / 2; k++)// 如果把一圈当作一个循环的话，那整体循环N/2次
		{
			for (j = n - 1; j > k; j--)// 给100-92赋值
				a[i][j] = last--;
			for (i = n - 1; i > k; i--)// 给91-83赋值
				a[i][j] = last--;
			for (; j < n - 1; j++) // 给82-74赋值
				a[i][j] = last--;
			for (; i < n - 1; i++) // 给73-65
				a[i][j] = last--;
			// 最外面的一圈赋值完成了，进行下一圈。
			n--;
			i--;
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
