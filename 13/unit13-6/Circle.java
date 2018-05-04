
public class Circle {
	private double radius = 1.0D;
	Circle(){
		this(1.0);
	}
	Circle(double radius){
		this.radius = radius;
	}
	public double getArea(){
		return Math.PI * radius * radius;
	}
}
class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
	ComparableCircle(){
		super();
	}
	ComparableCircle(double radius){
		super(radius);
	}
	@Override
	public int compareTo(ComparableCircle c){
		if(this.getArea() > c.getArea())
			return 1;
		else if(this.getArea() < c.getArea())
			return -1;
		else
			return 0;
	}
}
