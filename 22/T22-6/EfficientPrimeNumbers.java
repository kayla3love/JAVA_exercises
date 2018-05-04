import java.util.ArrayList;
import java.util.Scanner;

public class EfficientPrimeNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Find all prime numbers <= n, enter n: ");
		int n = input.nextInt();
		
		ArrayList<Integer> primeNumber = new ArrayList<>();
		primeNumber.add(2);
		int number = 3;
		boolean isPrime = true;
		int squareRoot = 2;
		while(number <= n) {
			isPrime = true;
			if(squareRoot * squareRoot < number)
				squareRoot++;
			for(int a : primeNumber) {
				if(a > squareRoot)
					break;
				if(number % a == 0) {
					isPrime = false;
					break;
				}
			}	
			if(isPrime)
				primeNumber.add(number);
			number++;
		}
		for(int a : primeNumber)
			System.out.print(a + " ");
	}

}
