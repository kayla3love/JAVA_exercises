import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ListHandle {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();
		String[] s = number.split(" ");
		for(String s1 : s) {
			linkedList.add(Integer.parseInt(s1));
		}
		printIt(linkedList);
		Collections.sort(linkedList);
		printIt(linkedList);
		Collections.shuffle(linkedList);
		printIt(linkedList);
		Collections.reverse(linkedList);
		printIt(linkedList);
		Collections.sort(linkedList, Collections.reverseOrder());
		printIt(linkedList);
		
	}
	public static void printIt(LinkedList<Integer> linkedList) {
		for(Integer num : linkedList) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
