
public class ColorableTest {
	public static void main(String[] args) {
		GeometricObject[] g = new GeometricObject[5];
		g[1] = new Square();
		g[2] = new Square();
		for(int i = 0; i < 5; i++){
			if(g[i] instanceof Colorable){
				((Colorable)g[i]).howToColor();
			}
		}
	}
}

interface Colorable{
	public abstract void howToColor();
}
class Square extends GeometricObject implements Colorable{
	@Override
	public double getArea(){
		return 1.0D;
	}
	@Override
	public double getPerimeter(){
		return 1.0D;
	}
	@Override
	public void howToColor(){
		System.out.println("Color all four sides");
	}
}
class Circle extends GeometricObject{
	
	@Override
	public double getArea(){
		return 1.0D;
	}
	@Override
	public double getPerimeter(){
		return 1.0D;
	}
}