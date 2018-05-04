import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class FindMinDistance {

	public static void main(String[] args) {
		Point[] list = new Point[20];
		Random random1 = new Random(1);
		Random random2 = new Random(2);
		for(int i = 0; i< 20; i++) {
			list[i] = new Point(random1.nextDouble() * 100, random2.nextDouble() * 100);
		}
		 Arrays.sort(list);
		 System.out.println(distance(list, 0, list.length));
	}
	/*public static Pair getClosestPair(Point[] points) {	
		
	}*/
	public static Pair distance(Point[] pointsOrderedOnX, int low, int high) {
		if(low == high - 1) {
			return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
		}
		if(low == high)
			return new Pair(pointsOrderedOnX[low], new Point(200, 200));
		int center = low + (high - low - 1) / 2;
		Pair dis1 = distance(pointsOrderedOnX, low, center);
		Pair dis2 = distance(pointsOrderedOnX, center + 1, high - 1);
		Pair select = dis1.getDistance() < dis2.getDistance() ? dis1:dis2;
		ArrayList<Point> nearPoints = new ArrayList<>();
		for(Point p : pointsOrderedOnX) {
			if(Math.abs(pointsOrderedOnX[center].getX() - p.getX()) < select.getDistance()) {
				nearPoints.add(p);
			}
		}
		Collections.sort(nearPoints, new CompareY());
		for(int i = 0; i < nearPoints.size() - 1; i++) {
			for(int j = i + 1; j < nearPoints.size(); j++) {
				if(nearPoints.get(j).getY() - nearPoints.get(i).getY() > select.getDistance()) {
					break;
				}
				double d = new Pair(nearPoints.get(j), nearPoints.get(i)).getDistance();
				if(d < select.getDistance()) {
					select = new Pair(nearPoints.get(j), nearPoints.get(i));
				}
			}
		}
		return select;
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
class CompareY implements Comparator<Point>{

	@Override
	public int compare(Point o1, Point o2) {
		if(o1.getY() > o2.getY())
			return 1;
		else if(o1.getY() < o2.getY())
			return -1;
		else {
			if(o1.getX() > o2.getX())
				return 1;
			else if(o1.getX() < o2.getX())
				return -1;
			else 
				return 0;
		}
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