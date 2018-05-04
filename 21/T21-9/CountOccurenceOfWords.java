import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOccurenceOfWords {

	public static void main(String[] args) {
		TreeMap<String, Integer> words = new TreeMap<>();
		try {
			Scanner input = new Scanner(new File("E:/eclipse-workspace/Test21-7/b.txt"));
			while(input.hasNext()) {
				String s1 = input.next();
				if(words.containsKey(s1))
					words.put(s1, words.get(s1) + 1);
				else
					words.put(s1, 1);
			}
			
			for(Map.Entry<String, Integer> a : words.entrySet())
				System.out.println(a.getKey() + "\t" + a.getValue());
				
		}catch(Exception ex) {ex.printStackTrace();}
	}
}
