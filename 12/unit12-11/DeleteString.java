import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
public class DeleteString {

	public static void main(String[] args) throws Exception {
		
		File file = new File("1.txt");
			Scanner input = new Scanner(file);
			ArrayList<String> newString = new ArrayList<>();
			while(input.hasNext()){
				String s1 = input.nextLine();
				String s2 = s1.replaceAll("apple", "");
				newString.add(s2);	
			}
			PrintWriter output = new PrintWriter(new File("1.txt"));
			for(String s : newString){
				output.println(s);
			}
			output.close();
	}
}
