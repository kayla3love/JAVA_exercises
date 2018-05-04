import java.util.*;

import org.w3c.dom.events.EventException;
public class Calculate {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		s = s.replaceAll(" ", "");
		try{
			String[] s2 = s.split("[+-./]");
			int num1 = Integer.parseInt(s2[0]);
			int num2 = Integer.parseInt(s2[1]);

		char operator = ' ';
		int result = 0;
		for(int i = 0; i < s.length(); i++){
			if(!Character.isDigit(s.charAt(i))){
				operator = s.charAt(i);
			}
		}
		switch(operator){
			case '+' : result = num1 + num2;
					   break;
			case '-' : result = num1 - num2;
			   break;
			case '.' : result = num1 * num2;
			   break;
			case '/' : result = num1 / num2;
			   break;
		}
		for(int i = 0; i < s.length(); i++){
			System.out.print(s.charAt(i));
		}
		System.out.print(" is " + result);
		}catch(NumberFormatException ex){System.out.print("Wrong");};
	}
}
