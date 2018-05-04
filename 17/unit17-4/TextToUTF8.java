import java.io.*;
public class TextToUTF8 {

	public static void main(String[] args) throws IOException{
		String data = null;
		int r;
		int countOfTxt = 0;
		int countOfDat = 0;
		try(
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("1.txt")));
			FileInputStream input1 = new FileInputStream("1.txt");
			DataOutputStream output = new DataOutputStream(new FileOutputStream("1.dat"));
			FileInputStream input2 = new FileInputStream("1.dat");
			RandomAccessFile input3 = new RandomAccessFile(new File("1.txt"),"r");
			RandomAccessFile input4 = new RandomAccessFile(new File("1.dat"),"r");
		){
			while((data = input.readLine()) != null){
				//output.writeChars(data);
				output.writeUTF(data);
			}
			while((input1.read() != -1)){
				countOfTxt++;
			}
			while((input2.read() != -1)){
				countOfDat++;
			}
			System.out.println(countOfTxt);
			System.out.println(countOfDat);		
			System.out.println(new File("1.txt").length());	
			System.out.println(new File("1.dat").length());	
			System.out.println(input3.length());	
			System.out.println(input4.length());	
		}
	}
}
