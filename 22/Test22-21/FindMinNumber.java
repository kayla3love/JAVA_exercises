import java.util.ArrayList;

public class FindMinNumber {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			int num = (int)(Math.random() * 100);
			list.add(num);
			System.out.print(num + " ");
		}
		System.out.println("\nthe smallest number in the list is: " + findMin(list, 0, list.size() - 1));
	}
	public static int findMin(ArrayList<Integer> list, int start, int end) {
		if(start == end)
			return list.get(start);
		if(start == end - 1)
			return Math.min(list.get(start), list.get(end));
		int center = start + (end - start -1)/2;
		int a1 = findMin(list, start, center);
		int a2 = findMin(list, center + 1, end);
		return Math.min(a1, a2);
	}
}

