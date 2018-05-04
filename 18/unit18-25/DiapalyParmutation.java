import java.util.Scanner;

public class DiapalyParmutation {
	private static int count = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		diaplayPermuation(s);
	}
	public static void diaplayPermuation(String s){
		String s2 = s;
		String s1 = "";
		diaplayPermuation(s1, s2);
	}
	public static void diaplayPermuation(String s1, String s2){
		if(s2.length() == 0){
			System.out.println(s1 + " " + (++count));
		}
		else{
			for(int i = 0; i < s2.length(); i++){
				diaplayPermuation(s1 + s2.charAt(i), s2.substring(0,i) + s2.substring(i+1));
			}
		}
	}
}
