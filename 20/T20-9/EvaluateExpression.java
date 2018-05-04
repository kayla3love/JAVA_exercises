import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if((c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/' || c1 == '(' || c1 == ')' || c1 == '%' || c1 == '^' ) && i != 0) {
				result += " " + c1 + " ";
			}
			else if(i == 0 && c1 == '(') {
				result += c1 + " ";
			}
			else
				result += c1;
		}
		String[] s1 = result.split(" +");
		Stack<Character> operatorStack = new Stack<>();
		Stack<Integer> operandStack = new Stack<>();
		try {
		for(String c : s1) {
			judgeAndHandle(c, operatorStack, operandStack);
		}
		while(!operatorStack.isEmpty()) {
			handle(operatorStack, operandStack);
		}
		System.out.println(operandStack.pop());
		}catch(Exception ex) {System.out.println("wrong expression: " + s);}
		
				
	}
	public static void judgeAndHandle(String s, Stack<Character> operatorStack, Stack<Integer> operandStack) {
		char c = s.charAt(0);
		
		if(c == '+' || c == '-') {
			while(!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '%' || operatorStack.peek() == '^'))
				handle(operatorStack, operandStack);
			operatorStack.push(c);
		}
		else if(c == '^') {
			while(!operatorStack.isEmpty() && (operatorStack.peek() == '^'))
				handle(operatorStack, operandStack);
			operatorStack.push(c);
		}
		else if(c == '*' || c == '/' || c == '%') {
			while(!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '%' || operatorStack.peek() == '^'))
				handle(operatorStack, operandStack);
			operatorStack.push(c);
		}
		else if(c == '(') {
			operatorStack.push(c);
		}
		else if(c == ')') {
			while(operatorStack.peek() != '(')
				handle(operatorStack, operandStack);
			operatorStack.pop();
		}
		else
			operandStack.push(Integer.valueOf(s));
	}
	public static void handle(Stack<Character> operatorStack, Stack<Integer> operandStack) {
		char c = operatorStack.pop();
		int num1 = operandStack.pop();
		int num2 = operandStack.pop();
		if(c == '+')
			operandStack.push(num1 + num2);
		else if(c == '-') 
			operandStack.push(num2 - num1);
		else if(c == '*')
			operandStack.push(num1 * num2);
		else if(c == '/')
			operandStack.push(num2 / num1);	
		else if(c == '%')
			operandStack.push(num2 % num1);	
		else if(c == '^')
			operandStack.push((int)Math.pow(num2, num1));	
		}
}
