import java.util.Scanner;

public class ComputeFibonacci {

	public static void main(String[] args) {
		System.out.println("Enter a n > 0");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 0; i < n; i++){
			System.out.print(fibonacci(i) + " ");
		}
	}
	public static int fibonacci(int n){
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
