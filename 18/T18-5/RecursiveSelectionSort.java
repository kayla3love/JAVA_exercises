import java.util.Scanner;

public class RecursiveSelectionSort {
	public static void sort(double[] number){
		sort(number, 0);
	}
	public static void sort(double[] number, int first){
		if(first <= number.length - 1){
			double min = number[first];
			int index = first;
			for(int i = first; i < number.length; i++){
				if(number[i] < min){
					min = number[i];
					index = i;
				}
			}
			number[index] = number[first];
			number[first] = min;
			System.out.print(number[first] + " ");
			first++;
			sort(number, first);
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] num = new double[10];
		for(int i = 0; i < 10; i++){
			num[i] = input.nextDouble();
		}
		sort(num);
	}
}