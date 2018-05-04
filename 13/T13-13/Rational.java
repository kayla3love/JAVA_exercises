
public class Rational extends Number implements Comparable<Rational>{
	private long numerator = 0;
	private long denominator = 1;
	public Rational(){
		this(0,1);
	}
	public Rational(long numerator, long denominator ){
		long gcd = gcd(numerator, denominator);
		this.numerator = (denominator > 0 ? 1 : -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}
	
	private static long gcd(long n, long d){
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
		for(int k = 2; k <= n1 && k <= n2; k++){
			if(n1 % k == 0 && n2 % k == 0 ){
				gcd = k;
			}
		}
		return gcd;
	}
	
	public long getNumerator(){
		return numerator;
	}
	public long getDenominator(){
		return denominator;
	}
	
	public Rational add(Rational r){
		long n = this.numerator * r.denominator + this.denominator * r.numerator;
		long d = this.denominator * r.denominator;
		return new Rational(n,d);
	}
	public Rational subtract(Rational r){
		long n = this.numerator * r.denominator - this.denominator * r.numerator;
		long d = this.denominator * r.denominator;
		return new Rational(n,d);
	}
	public Rational multiply(Rational r){
		long n = this.numerator * r.numerator;
		long d = this.denominator * r.denominator;
		return new Rational(n,d);
	}
	public Rational divide(Rational r){
		long n = this.numerator * r.denominator;
		long d = this.denominator * r.numerator;
		return new Rational(n,d);
	}
	@Override 
	public int compareTo(Rational r){
		if(this.subtract(r).getNumerator() > 0)
			return 1;
		else if(this.subtract(r).getNumerator() < 0)
			return -1;
		else
			return 0;
	}
	@Override
	public int intValue(){
		return (int)this.doubleValue();
	}
	@Override 
	public double doubleValue(){
		return numerator * 1.0 / denominator;
	}
	@Override
	public float floatValue(){
		return (float)this.doubleValue();
	}
	@Override
	public long longValue(){
		return (long)this.doubleValue();
	}
	@Override
	public boolean equals(Object other){
		if((this.subtract((Rational)other).getNumerator() == 0)){
			return true;
		}
		else
			return false;
	}
	public String toString(){
		if(denominator == 1)
			return numerator + "";
		else if(numerator == 0)
			return 0 +"";
		else
			return numerator + "/" + denominator;
	}
}
