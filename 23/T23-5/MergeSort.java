import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] list = new int[51];
		for(int i = 0; i < 51; i++) {
			list[i] = (int)(Math.random() * 100);
		}
		for(int a : list)
			System.out.print(a + " ");
		System.out.println();
		mergeSort(list);
		for(int a : list)
			System.out.print(a + " ");
	}
	public static void mergeSort(int[] list) {
		int length = list.length;
		int halfLength = (int)(length / 2);
		if(length > 1) {
			int[] model1 = Arrays.copyOfRange(list, 0, halfLength);
			int[] model2 = Arrays.copyOfRange(list, halfLength, length);
			mergeSort(model1);
			mergeSort(model2);
			sort(model1, model2, list);
		}
	}

	public static void sort(int [] list1, int[] list2, int[] temp) {
		int length1 = list1.length;  //length1С
		int length2 = list2.length;
		int i , j;
		int k = 0;
		for(i = 0, j = 0; i < length1 && j < length2; k ++) {
			if(list1[i] < list2[j]) 
				temp[k] = list1[i++];
			else 
				temp[k] = list2[j++];

		}
		while(i <= length1 - 1) {
			temp[k++] = list1[i++];
		}
		while(j <= length2 - 1) {
			temp[k++] = list2[j++];
		}
	}

	public static int[] mergeSort1(int[] list) {
		int[] newList = null;
		for(int j = 0; j < 10; j ++) {
			if(list.length > Math.pow(2, j) && list.length < Math.pow(2, j + 1)) {
				newList = new int[(int)Math.pow(2, j + 1)];
				System.arraycopy(list, 0, newList, 0, list.length);
			}
		}
		ArrayList<int[]> lists = new ArrayList<>();
		for(int i = 0; i < newList.length; i++)
			lists.add(Arrays.copyOfRange(newList, i, i + 1));
		ArrayList<int[]> lists2 = new ArrayList<>();
		while(lists.size() > 1) {
			int k = 0;
			while( k + 1 < lists.size()) {
				int[] list1 = lists.get(k);
				int[] list2 = lists.get(k + 1);
				int[] temp = new int[list1.length + list2.length];
				sort(list1, list2, temp);
				lists2.add(temp);
				k = k + 2;
			}
			lists = (ArrayList<int[]>) lists2.clone();
			lists2.clear();
		}
		System.arraycopy(lists.get(0), lists.get(0).length - list.length, list, 0, list.length);
		return list;
	}
}
