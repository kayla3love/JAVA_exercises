
public class InsertionSort {

	public static void main(String[] args) {
		int[] list = new int[10];
		for(int i = 0; i < 10; i++) {
			list[i] = (int)(Math.random() * 100);
		}
		for(int a : list)
			System.out.print(a + " ");
		insertionSort(list);
		System.out.println();
		for(int a : list)
			System.out.print(a + " ");
	}
	public static void insertionSort(int[] list) {
		for(int i = 1; i < list.length; i++) {
			int num = i;
			int originalValue = list[i];
			for(int j = i - 1; j >= 0 && originalValue <= list[j]; j--) {
				list[j + 1] = list[j];
				num = j;
			}
			list[num] = originalValue;
		}
	}
}
