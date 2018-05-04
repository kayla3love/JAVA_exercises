import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort {

	public static void main(String[] args) {
		final int size = 7000000;
		int[] list1 = new int[size];
		int[] list2 = new int[size];
		for(int i = 0; i < list1.length; i++){
			list1[i] = list2[i] = (int)(Math.random() * 100000);
		}
		
		long startTime = System.currentTimeMillis();
		parallelMergeSort(list1);
		long endTime = System.currentTimeMillis();
		System.out.println(Runtime.getRuntime().availableProcessors() + " :" + (endTime - startTime));
		long startTime1 = System.currentTimeMillis();
		//采用一般的归并排序
		mergeSort(list2);
		long endTime1 = System.currentTimeMillis();
		System.out.println(Runtime.getRuntime().availableProcessors() + " :" + (endTime1 - startTime1));
	}
	//采用并行编程方法
	public static void parallelMergeSort(int[] list){
		RecursiveAction mainTask = new SortTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(mainTask);
	}
	private static class SortTask extends RecursiveAction{
		private final int THRESHOLD = 50;
		private int[] list;
		SortTask(int[] list){
			this.list = list;
		}
		@Override
		protected void compute() {
			if(list.length < THRESHOLD){
				Arrays.sort(list);
			}
			else{
				int[] firstHalf = new int[list.length / 2];
				System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
				int[] secondHalf = new int[list.length - list.length / 2];
				System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalf.length);
				
				//分解给定的任务（在不同的线程上并行实现）
				invokeAll(new SortTask(firstHalf), new SortTask(secondHalf));
				merge(firstHalf, secondHalf, list);
			}		
		}	
	}
	public static void mergeSort(int[] list){
		if(list.length > 1){
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
	
			int[] secondHalf = new int[list.length - list.length / 2];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalf.length);
			
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}
	public static void merge(int[] first, int[] second, int[] list){
		int firstNum = 0;
		int secondNum = 0;
		int listNum = 0;
		while(firstNum < first.length && secondNum < second.length){
			if(first[firstNum] < second[secondNum]){
				list[listNum++] = first[firstNum++];
			}
			else
				list[listNum++] = second[secondNum++];
		}
		while(firstNum < first.length){
			list[listNum++] = first[firstNum++];
		}
		while(secondNum < second.length){
			list[listNum++] = second[secondNum++];
		}
	}
}
