import java.util.*;
import java.math.*;
public class MaxValue {

	public static void main(String[] args) {
		int counts = 0;
		String s = String.valueOf(Long.MAX_VALUE);
		BigInteger b = new BigInteger(s);
		long l = (long)(Math.sqrt(Long.MAX_VALUE));
		for(long i = l, count = 0; i < Long.MAX_VALUE && count <= 10; i++){
			BigInteger result = new BigInteger(String.valueOf(i));
			result = result.multiply(result);
			if(result.compareTo(b) > 0){
				System.out.println(result + " " + i);
				count++;
			}	
		}
	}
}
