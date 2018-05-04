import java.util.ArrayList;
import java.util.Scanner;

public class Recursive {

	public static void main(String[] args) {
		System.out.println("Enter a string to test");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println(judge(s));
	}
	public static boolean judge(String s){
		if(s.length() <= 1)
			return true;
		else if(s.charAt(0) != s.charAt(s.length() - 1))
			return false;
		else{
			return judge(s.substring(1, s.length() - 1));
		}
	}
}
