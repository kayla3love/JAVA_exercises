
public class SumArea {

	public static void main(String[] args) {
		GeometricObject[] g = new GeometricObject[4];
		g[0] = new Circle(1);
		g[1] = new Circle(1);
		g[2] = new Rectangle(1,1);
		g[3] = new Rectangle(1,1);
		System.out.println("the total area is: " + sumArea(g));
	}
	public static double sumArea(GeometricObject[] g){
		double sumArea = 0.0;
		for(int i = 0; i < g.length; i++){
			if(g[i] instanceof GeometricObject){
				sumArea += g[i].getArea();
			}
		}
		return sumArea;
	}
}
class Circle extends GeometricObject{
	private double radius;
	Circle(){
		this(1.0);
	}
	Circle(double radius){
		this.radius = radius;
	}
	@Override
	public double getArea(){
		return Math.PI * radius * radius;
	}
	@Override
	public double getPerimeter(){
		return Math.PI * 2 * radius;
	}
}
class Rectangle extends GeometricObject{
	private double width;
	private double height;
	Rectangle(){
		this(1.0, 1.0);
	}
	Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	@Override
	public double getArea(){
		return width * height;
	}
	@Override
	public double getPerimeter(){
		return 2 * (width + height);
	}
}