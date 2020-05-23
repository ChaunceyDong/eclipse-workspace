import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = 0;
		int b = 0;
		while (true) {
			int m = in.nextInt();
			if (m == -1)
				break;
			if (m % 2 == 0) {
				a = a + 1;
			} else
				b = b + 1;

		}
		in.close();
		System.out.println(a + " " + b);
	}

}
