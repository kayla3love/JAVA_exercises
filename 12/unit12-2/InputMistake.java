import java.util.*;
public class InputMistake {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continues = true;
		do{
			System.out.println("Enter two integer number ");
			try{
				int a = input.nextInt();
				int b = input.nextInt();
				System.out.println("sum is " + (a + b));
				continues = true;
			}catch(InputMismatchException ex){
				System.out.println("please enter again");
				input.nextLine();
				continues = false;
			}
		}while(continues == false);
	}
}
