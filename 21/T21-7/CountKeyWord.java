//统计文件中的java关键字个数
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CountKeyWord {
	private static String[] keyWord= {"public", "private", "static"};
	public static HashSet<String> keyWords = new HashSet<>(Arrays.asList(keyWord));
	public static void main(String[] args) {
		File file = new File("E:\\eclipse-workspace\\Unit20-9\\application\\Main.java");
		try {
			System.out.println(countKeyWords(file));
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static int countKeyWords(File file) throws IOException {
		Scanner input = new Scanner(file);
		int count = 0;
		while(input.hasNext()) {
			if(keyWords.contains(input.next()))
				count++;
		}
		return count;
	}
}
