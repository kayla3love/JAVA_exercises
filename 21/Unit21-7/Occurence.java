import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Occurence {

	public static void main(String[] args) {
		TreeSet<WordOccurence> list = new TreeSet<>();
		HashMap<String, Integer> words = new HashMap<>();
		try {
			Scanner input = new Scanner(new File("E:/eclipse-workspace/Test21-7/b.txt"));
			while(input.hasNext()) {
				String s1 = input.next();
				if(words.containsKey(s1))
					words.put(s1, words.get(s1) + 1);
				else
					words.put(s1, 1);
			}
			for(Map.Entry<String, Integer> a : words.entrySet()) {
				WordOccurence occ = new WordOccurence(a.getKey(), a.getValue());
				list.add(occ);
			}
		//	Collections.sort(list);
			for(WordOccurence w : list) {
				System.out.println(w.getCount() + " " + w.getWord());
			}
		}catch(Exception ex) {ex.printStackTrace();}

	}

}
class WordOccurence implements Comparable<WordOccurence>{
	private int count;
	private String word;
	public WordOccurence(String word,int count) {
		this.word = word;
		this.count = count;
	}
	@Override
	public int compareTo(WordOccurence o) {
		if(this.count < o.count)
			return -1;
		else if(this.count > o.count)
			return 1;
		else
			return 0;
	}
	public String getWord() {
		return word;
	}
	public int getCount() {
		return count;
	}
	
}