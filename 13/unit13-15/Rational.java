import java.math.*;
public class Rational implements Comparable<Rational>{
	public static final BigInteger two = new BigInteger("2");
	public static final BigInteger zero = new BigInteger("0");
	public static final BigInteger one = new BigInteger("1");
	private BigInteger numerator = new BigInteger("0");
	private BigInteger denominator = new BigInteger("1");
	public Rational(){
		this(zero,one);
	}
	public Rational(BigInteger numerator, BigInteger denominator ){
		BigInteger gcd = numerator.gcd(denominator);
		if(denominator.compareTo(zero) == 1){
			this.numerator = numerator.divide(gcd);
		}
		else if(denominator.compareTo(zero) == -1){
			this.numerator = new BigInteger("-1").divide(gcd).multiply(numerator);
		}
		this.denominator = denominator.abs().divide(gcd);
	}
	
	public BigInteger getNumerator(){
		return numerator;
	}
	public BigInteger getDenominator(){
		return denominator;
	}
	
	public Rational add(Rational r){
		BigInteger n = (this.numerator.multiply(r.denominator)).add(this.denominator.multiply(r.numerator));
		BigInteger d = this.denominator.multiply(r.denominator);
		return new Rational(n,d);
	}
	public Rational subtract(Rational r){
		BigInteger n = this.numerator.multiply(r.denominator).subtract(this.denominator.multiply(r.numerator));
		BigInteger d = this.denominator.multiply(r.denominator);
		return new Rational(n,d);
	}
	public Rational multiply(Rational r){
		BigInteger n = this.numerator.multiply(r.numerator);
		BigInteger d = this.denominator.multiply(r.denominator);
		return new Rational(n,d);
	}
	public Rational divide(Rational r){
		BigInteger n = this.numerator.multiply(r.denominator);
		BigInteger d = this.denominator.multiply(r.numerator);
		return new Rational(n,d);
	}
	@Override 
	public int compareTo(Rational r){
		if(this.subtract(r).getNumerator().compareTo(zero) > 0)
			return 1;
		else if(this.subtract(r).getNumerator().compareTo(zero) < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public boolean equals(Object other){
		if((this.subtract((Rational)other).getNumerator().equals(zero))){
			return true;
		}
		else
			return false;
	}
	public String toString(){
		if(denominator.equals(one))
			return numerator + "";
		else if(numerator.equals(zero))
			return 0 +"";
		else
			return numerator + "/" + denominator;
	}
}
