import java.math.*;
public class TestRationalClass {

	public static void main(String[] args) {
		Rational r1 = new Rational(Rational.one, new BigInteger("123456789"));
		Rational r2 = new Rational(Rational.one, new BigInteger("12345678"));
		System.out.println(r1 + "+" + r2 + "=" + r1.add(r2));
		System.out.println(r1 + "-" + r2 + "=" + r1.subtract(r2));
		System.out.println(r1 + "*" + r2 + "=" + r1.multiply(r2));
		System.out.println(r1 + "/" + r2 + "=" + r1.divide(r2));
		System.out.println(r1.getNumerator());
		System.out.println(r1.getDenominator());

	/*	Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(1,-2);
		System.out.println(r1.add(r2));*/
	}
}
