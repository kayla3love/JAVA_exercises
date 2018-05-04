import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println("Enter a string");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		reverseDisplay(s);
	}
	public static void reverseDisplay(String s){
		int high = s.length() - 1;
		reverseDisplay(s, high);
	}
	public static void reverseDisplay(String s, int high){
		if(high >= 0){
			System.out.print(s.charAt(high--));
			reverseDisplay(s, high);
		}
	}
	
}
