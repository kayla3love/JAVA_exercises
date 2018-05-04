import java.util.Arrays;
import java.util.Random;

public class MinDistance {
	public static void main(String[] args) {
		Point[] list = new Point[20];
		Random random1 = new Random(1);
		Random random2 = new Random(2);
		for(int i = 0; i< 20; i++) {
			list[i] = new Point(random1.nextDouble() * 100, random2.nextDouble() * 100);
		}
		double distance = 200;
		Pair minPair = new Pair(new Point(0,0), new Point(0,0));
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list.length; j++) {
				Pair pair = new Pair(list[i], list[j]);
				if(distance > pair.getDistance() && i != j) {
					distance = pair.getDistance();
					minPair = pair;
				}
			}
		}
		System.out.println(minPair);
	}
}

class Point implements Comparable<Point>{
	private double x;
	private double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		if(this.x > o.x)
			return 1;
		else if(this.x < o.x)
			return -1;
		else {
			if(this.y > o.y)
				return 1;
			else if(this.y < o.y)
				return -1;
			else 
				return 0;
		}
	}
    public double getX(){
    	return this.x;
    }
    public double getY() {
    	return this.y;
    }
}
class Pair{
	private Point p1;
	private Point p2;
	public Pair(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	public double getDistance() {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}
	public String toString() {
		return "the first point is: (" + p1.getX() + ", " + p1.getY() + ")" + "\nthe second point is: (" + p2.getX() + ", " + p2.getY() + ")";
	}
}
