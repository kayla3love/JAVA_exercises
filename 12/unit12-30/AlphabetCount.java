import java.util.*;
import java.io.*;
public class AlphabetCount {

	public static void main(String[] args) throws Exception{
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter a FilePath");
		String filePath = input1.nextLine();
		Scanner input2 = new Scanner(new File(filePath));
		int[] count = new int[26];
		count = alphabetCount(count, input2);
		for(int i = 0; i < 26; i++){
			System.out.println("Number of " + (char)('a' + i) + "'s: " + count[i]);
		}

	}
	public static int[] alphabetCount(int[] count, Scanner input2 ){
		while(input2.hasNext()){
			String s = input2.nextLine();
			for(int i = 0; i < s.length(); i++){
				char c = s.charAt(i);
				int num = c - 'a';
				if(num >= 0 && num <= 25){
					count[num]++;
				}
			}
		}
		return count;
	}
}
