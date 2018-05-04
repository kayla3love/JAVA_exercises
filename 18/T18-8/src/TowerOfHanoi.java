
public class TowerOfHanoi {

	public static void main(String[] args) {
		System.out.println(moveDisks(4,'A','B','C'));
	}
	public static int moveDisks(int n, char fromTower, char toTower, char auxTower){
		int count = 0;
		if(n == 1){
			System.out.println("Move disk 1 from Tower " + fromTower +" to Tower " + toTower);
			return ++count;
		}
		else{
			count += moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from Tower " + fromTower + " to Tower " + toTower);
			++count;
			count += moveDisks(n - 1, auxTower, toTower, fromTower);
			return count;
		}	
	}
}
