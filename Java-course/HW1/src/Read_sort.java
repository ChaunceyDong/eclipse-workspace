import java.util.Scanner;

public class Read_sort {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int[] array = new int[10];
//		for (int i=0;i<array.length;++i)
//			array[i] = scan.nextInt();
//		Read_sort obj=new Read_sort();
//		obj.sort(array);
//		for (int i=0;i<array.length;++i)
//			System.out.println(array[i]);
//		scan.close();
		
		Scanner scan = new Scanner(System.in);
		int[] array = new int[10];
		for (int i=0;i<array.length;++i)
			array[i] = scan.nextInt();
		int a = 0;
		int b = 0;
		int i = 0;
		while (true) {
			int m = array[i];
			if(m == -1)
				break;
			if( m == -1)
				break;
			if(m % 2 == 0)
				a = a +1;
			else
				b = b+1;	
			i++;
		}
		scan.close();
		System.out.println(a + " "+ b);
		
	}
	
	
	
	
	void sort(int[] arg) {
		for (int i=0;i<arg.length-1;++i){
			for(int j=0;j<arg.length-1-i;++j){
				if(arg[j]>arg[j+1]){
					int x=arg[j];
					arg[j]=arg[j+1];
					arg[j+1]=x;
				}
			}
		}
	}
}