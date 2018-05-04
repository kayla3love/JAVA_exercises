import java.util.Scanner;

public class ImprovedFibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter an index for Fibonacci number: ");
		int num = input.nextInt();
		int f0 = 0;
		int f1 = 1;
		int f2 = 1;
		for(int i = 1; i <= num; i++) {
			System.out.print(f2 + " ");
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}

	}

}
