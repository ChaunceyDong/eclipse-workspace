
public class SortingTest {

	public static void main(String[] args) {
		char[] array = "ChaunceyDong".toLowerCase().toCharArray();//*********
		System.out.println("Before Sorting:");
		for (int i = 0; i < array.length; ++i) {
			System.out.println(array[i]);
		}
		
		BubbleSort bsort = new BubbleSort(array);
		bsort.sort();
		
		System.out.println("After Sorting:");
		for (int i = 0; i < array.length; ++i) {
			System.out.println(array[i]);
		}

	}

}

class BubbleSort {
	private char[] data;
	
	public BubbleSort(char[] data) {
		this.data = data;
	}
	
	public void sort() {
		for (int i = 0; i < data.length - 1; ++i) 
			for (int j = 0; j < data.length - i -1; ++j)
				if (data[j] > data[j+1]) {
					char tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
 				}
	}
}
