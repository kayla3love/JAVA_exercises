
public class FindMax {

	public static void main(String[] args) {
		int[] num = new int[100];
		int[] num1 = new int[10];
		int max = 0;
		for(int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random() * 10);
			System.out.print(num[i] + " ");
		}
		for(int a : num) {
			num1[a]++;
			if(max < a)
				max = a;
		}
		System.out.println("\n" + max + " " + num1[max]);
	}

}
