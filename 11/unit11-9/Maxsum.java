import java.util.*;
public class Maxsum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the array size n: ");
		int num = input.nextInt();
		int[][] matrix = createArray(num);
		printMatrix(matrix);
		sumRow(matrix);
		sumColumn(matrix);
		

	}
	public static int[][] createArray(int num){
		int[][] matrix = new int[num][num];
		for(int i = 0; i < num; i++){
			for(int j = 0; j < num; j++){
				matrix[i][j] = (int)(Math.random() * 2);
			}
		}
		return matrix;
	}
	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if((j + 1) % matrix[0].length == 0)
					System.out.println(matrix[i][j]);
				else
					System.out.print(matrix[i][j]);
			}
		}
	}
	public static void sumRow(int[][] matrix){
		ArrayList<Integer> sumRow = new ArrayList<>();
		int[] sum = new int[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				sum[i] += matrix[i][j]; 
			}
		}
		int[] a = sum.clone();
		Arrays.sort(a);
		for(int i = 0; i < sum.length; i++){
			if(sum[i] == a[sum.length - 1])
				sumRow.add(i + 1);
		}
		System.out.println("the largest row index: " + sumRow.toString());
	}
	public static void sumColumn(int[][] matrix){
		ArrayList<Integer> sumColumn = new ArrayList<>();
		int[] sum = new int[matrix.length];
		for(int i = 0; i < matrix[0].length; i++){
			for(int j = 0; j < matrix.length; j++){
				sum[i] += matrix[j][i]; 
			}
		}
		int[] a = sum.clone();
		Arrays.sort(a);
		for(int i = 0; i < sum.length; i++){
			if(sum[i] == a[sum.length - 1])
				sumColumn.add(i + 1);
		}
		System.out.println("the largest column index: " + sumColumn.toString());	
	}
}
