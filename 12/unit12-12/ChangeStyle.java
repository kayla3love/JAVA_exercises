import java.io.*;
import java.util.*;
public class ChangeStyle {

	public static void main(String[] args) {
		File file = new File("Test.java");
		ArrayList<String> list = new ArrayList<>();
		try{
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				String s1 = input.nextLine();
				list.add(s1);
			}
			PrintWriter output = new PrintWriter(file);
			for(String s : changeStyle(list)){
				output.println(s);
			}
			output.close();
		}catch(FileNotFoundException ex){
			System.out.println("File not found");
		}
		
	}
	public static ArrayList<String> changeStyle(ArrayList<String> list){
		
		for(int i = 0; i < list.size(); i++){
			String s = list.get(i);
			int count = 0;
			for(int j = 0; j < s.length(); j++){
				if(Character.isAlphabetic(s.charAt(j))){
					count++;
				}
			}
			if(list.get(i).contains("{") && count == 0){
				list.set(i -1 , list.get(i -1) + "{");
				list.remove(i);
				i--;
			}
		}
		return list;
	}
}
