import java.util.Arrays;
import java.util.Comparator;

public class RecursiveBinarySearch {

	public static void main(String[] args) {
		Double[] d = {2.3,2.5,7.5,3.8,5.4,3.4,1.0,9.8,55.0,6.0};
		Arrays.sort(d, new Compare());
		for(int i = 0; i < 10; i++){
			System.out.print(d[i] + " ");
		}
		System.out.println(" ");
		int[] test = {1,2,3,4,5,6,7,8,9,10};
		binarySearch(test, 9);
	}
	public static void binarySearch(int[] test, int key){
		int low = 0;
		int high = test.length - 1;
		System.out.println(binarySearch(test,key, low, high));
	}
	public static int binarySearch(int[] test, int key, int low, int high){
		if(low > high)
			return -low-1;    //Ê§°Ü
		int mid = (low + high) / 2;
		if(test[mid] < key)
			return binarySearch(test, key, mid + 1, high);
		else if(test[mid] == key)
			return mid;
		else
			return binarySearch(test, key, low, mid - 1);
	}
}
class Compare implements Comparator<Double>{
	@Override
	public int compare(Double a, Double b) {
		if(a > b){
			return -1;
		}
		else
			return 1;
	}	
}