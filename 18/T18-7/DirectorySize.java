import java.io.File;
import java.util.Scanner;

public class DirectorySize {

	public static void main(String[] args) {
		System.out.println("Enter a directory or a file");
		Scanner input = new Scanner(System.in);
		String file = input.nextLine();
		File files = new File(file);
		System.out.println(countSize(files));
	}
	public static long countSize(File files){
		long size = 0;
		if(files.isDirectory()){
			for(int i = 0; i < files.listFiles().length; i++){
				size += countSize(files.listFiles()[i]);
			}
		}
		else{
			size += files.length();
		}
		return size;
	}

}
