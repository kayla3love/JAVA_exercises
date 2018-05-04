import java.util.*;
public class BinToDec {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a bin number ");
		String s = input.nextLine();
		try{
			judge(s);
			bin2Dec(s);
		}catch(BinaryFormatException ex){
			ex.printStackTrace();
		}

	}
	public static void bin2Dec(String binaryString){
		int sum = 0;
		for(int i = binaryString.length() -1; i >= 0; i--){
			int a = binaryString.charAt(i) - '0';
			sum += a * Math.pow(2, binaryString.length() - 1 - i);
		}
		System.out.println(sum);
	}
	public static void judge(String s) throws BinaryFormatException{
		for(int i = 0; i < s.length(); i++){
			int a = s.charAt(i) - '0';
			if(a != 0 && a != 1){
				throw new BinaryFormatException("Wrong number");
			}
		}
	}
}
class BinaryFormatException extends Exception{
	public BinaryFormatException(String s){
		super(s);
	}
}
