
public class QuickSort {

	public static void main(String[] args) {
		int[] list = new int[8];
		for(int i = 0; i < list.length; i++){
			list[i] = (int)(Math.random() * 100);
		}
		for(int a : list){
			System.out.print(a + " ");
		}
		quickSort(list);
		System.out.println();
		for(int a : list){
			System.out.print(a + " ");
		}
	}
	public static void quickSort(int[] list){
		quickSort(list, 0, list.length - 1);
	}
	public static void quickSort(int[] list, int first, int last){
		if(last > first){
			int pivotIndex = partition1(list, first, last); //调用查找主元
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	//自己的想法
	public static int partition(int[] list, int first, int last){
		int halfNum = (last - first)/2 + first;
		int temp = list[first];
		list[first] = list[halfNum];
		list[halfNum] = temp;
		int pivot = list[first];
		int[] list1 = new int[list.length];
		int first1 = first;
		int last1 = last;
		for(int i = first + 1; i <= last; i++){
			if(list[i] <= pivot){
				list1[first1] = list[i];
				first1++;
			}
			else if(list[i] > pivot){
				list1[last1] = list[i];
				last1--;
			}		
		}
		list1[first1] = pivot;
		System.arraycopy(list1, first, list, first, last - first + 1);
		return first1;
	}
	//采用书上的方法，不需要临时数组，减提高了空间效率
	public static int partition1(int[] list, int first, int last){
		int pivot = list[first];
		int low = first + 1;
		int high = last;
		while(low < high){
			while(list[low] <= pivot)
				low++;
			while(list[high] > pivot)
				high--;
			if(high > low){
				int temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}
		while(list[low] > pivot)
			low--;
		int temp = list[low];
		list[low] = list[first];
		list[first] = temp;
		return low;
	}
}
