
public class BubbleSort {

		public static void main(String[] args) {
			int[] list = new int[10];
			for(int i = 0; i < 10; i++) {
				list[i] = (int)(Math.random() * 100);
			}
			for(int a : list)
				System.out.print(a + " ");
			bubbleSort2(list);
			System.out.println();
			for(int a : list)
				System.out.print(a + " ");
		}
		public static void bubbleSort1(int[] list) {
			for(int k = list.length - 1; k >= 1; k--) {
				for(int i = 0; i < k - 1; i++) {
					if(list[i] > list[i + 1]) {
						int temp = list[i];
						list[i] = list[i + 1];
						list[i + 1] = temp;
					}
				}
			}
		
		}
		public static void bubbleSort2(int[] list) {     //如果在某次遍历中没有发生交换，那么立刻停止，因为已经排好序了
			for(int k = list.length - 1; k >= 1; k--) {
				int num1 = 0;
				for(int i = 0; i < k - 1; i++) {
					if(list[i] > list[i + 1]) {
						int temp = list[i];
						list[i] = list[i + 1];
						list[i + 1] = temp;
						num1++;
					}
				}
				if(num1 == 0)
					break;
			}
		
		}
}
