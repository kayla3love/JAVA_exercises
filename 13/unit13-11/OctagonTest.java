
public class OctagonTest {
	public static void main(String[] args) {
		Octagon o = new Octagon(5);
		System.out.println("the area is " + o.getArea());
		System.out.println("the perimeter is  " + o.getPerimeter());
		try{
			Octagon o1 = (Octagon)o.clone();
			System.out.println(o.compareTo(o1));
		}catch(Exception ex){}
	}
}
class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
	private double side = 1.0D;
	Octagon(){
		this(1.0D);
	}
	Octagon(double side){
		this.side = side;
	}
	public double getSide(){
		return side;
	}
	@Override
	public double getArea(){
		return (2 + 4 / Math.sqrt(2)) * side * side;
	}
	public double getPerimeter(){
		return 8 * side;
	}
	@Override
	public int compareTo(Octagon o){
		if(getArea() > o.getArea())
			return 1;
		else if(getArea() < o.getArea())
			return -1;
		else
			return 0;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
  }