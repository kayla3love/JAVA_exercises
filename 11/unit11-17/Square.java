import java.util.*;
public class Square {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer m: ");
		int m = input.nextInt();
		int[] counts = new int[m + 1];
		ArrayList<Integer> num = new ArrayList<>();
		add(num,m);
		//System.out.println(add(num,m));
		int n = count(num,counts,m);
		System.out.println("the smallest number n for m * n to be a perfect square is " + n);
		System.out.println("m * n is " + m * n);
	}
	public static ArrayList<Integer> add(ArrayList<Integer> num, int m){
		int count = m;
		do{
			for(int i = 2; i <= count; i++){
				if(m % i == 0){
					m = m/i;
					Integer m1 = i;
					num.add(m1);
					break;
				}		
			}
		}while(m != 1);
		return num;
	}
    public static int count(ArrayList<Integer> num, int[] counts, int m){
    	int result = 1;
    	if(m != 1){
    		for(int i = Collections.min(num); i <= Collections.max(num); i++){
        		for(int j = 0; j <= num.size() - 1; j++){
        			if(num.get(j) == i)
        				counts[i] ++;
        		}
        	}
        	for(int i = 0; i < counts.length; i++){
        		if(counts[i] % 2 != 0)
        			result *= i;
        	}
    	}
    	return m == 1 ? 1 : result;
    }
}
