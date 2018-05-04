import java.util.*;
public class RemoveDuplicate {
	public static void main(String[] agrs){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter ten integers: ");
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			Integer num = input.nextInt();
			list.add(num);
		}
		removeDuplicate(list);
		System.out.print("the distinct integers are: ");
		System.out.print(list.toString());
	}
	public static void removeDuplicate(ArrayList<Integer> list){
		int count = list.size();
		for(int i = count - 1; i >= 0; i--){
			int num = list.get(i);
			if(list.contains(num) && list.indexOf(num) != i){
				list.remove(i);
			}
		}
	}

}
