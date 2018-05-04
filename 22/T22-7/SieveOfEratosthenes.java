import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter n");
		int n = input.nextInt();
		boolean[] primes = new boolean[n + 1];//�����һ����Ϊ�±��0��ʼ�������������Ǵ�2��ʼ�ģ�������0
		
		for(int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		
		for(int i = 2; i <= n/i; i++) {
			if(primes[i]) {
				for(int j = i; j <= n/i; j++)
					primes[j * i] = false;
			}
		}
		for(int i = 0; i < primes.length; i++) {
			if(primes[i])
				System.out.print(i + " ");
		}

	}

}
