
public class Complex implements Cloneable{
	private double realPart = 0;
	private double ImaginaryPart = 0;
	public Complex(){
		this(0,0);
	}
	public Complex(double a){
		this(a,0);
	}
	public Complex(double a, double b){
		this.realPart = a;
		this.ImaginaryPart = b;
	}
	public double getRealPart(){
		return this.realPart;
	}
	public double getImaginaryPart(){
		return this.ImaginaryPart;
	}
	public Complex add(Complex c){
		Complex addComplex = new Complex();
		addComplex.realPart = this.realPart + c.realPart;
		addComplex.ImaginaryPart = this.ImaginaryPart + c.ImaginaryPart;
		return addComplex;
	}
	@Override
	public String toString(){
		if(this.ImaginaryPart == 0)
			return this.realPart + "";
		else
			return this.realPart + "+" + this.ImaginaryPart + "i";
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
