
public class GenericMatrixTest {
	public static void main(String[] args) {
		Integer[][] m1 = new Integer[][]{{1,2,3}, {4,5,6}, {1,1,1}};
		Integer[][] m2 = new Integer[][]{{1,1,1}, {2,2,2}, {0,0,0}};
		IntegerMatrix integerMatrix = new IntegerMatrix();
		integerMatrix.addMatrix(m1, m2);
		GenericMatrix.printMatrix(m1, m2, integerMatrix.getOperator(), integerMatrix.getResult());
		integerMatrix.multiplyMatrix(m1, m2);
		System.out.println("");
		GenericMatrix.printMatrix(m1, m2, integerMatrix.getOperator(), integerMatrix.getResult());
	}
}

class IntegerMatrix extends GenericMatrix<Integer>{
	@Override
	public Integer add(Integer e1, Integer e2){
		return e1 + e2;
	}
	@Override
	public Integer multiply(Integer e1, Integer e2){
		return e1 * e2;
	}
	@Override
	public Integer zero(){
		return 0;
	}
}

class RationalMatrix extends GenericMatrix<Rational>{
	@Override
	public Rational add(Rational e1, Rational e2){
		return e1.add(e2);
	}
	@Override
	public Rational multiply(Rational e1, Rational e2){
		return e1.multiply(e2);
	}
	@Override
	public Rational zero(){
		return new Rational(0,1);
	}
}

abstract class GenericMatrix<E extends Number>{
	private E[][] result;
	private char operator;
	public E[][] addMatrix(E[][] e1, E[][] e2){
		operator = '+';
		if(e1.length != e2.length || e1[0].length != e2[0].length){
			throw new RuntimeException("the matrices do not have the same size");
		}
		result = (E[][])new Number[e1.length][e1[0].length];
		for(int i = 0; i <  result.length; i++){
			for(int j = 0; j <  result[0].length; j++){
				result[i][j] = add(e1[i][j], e2[i][j]);
			}
		}
		return result;	
	}
	public char getOperator(){
		return operator;
	}
	public E[][] getResult(){
		return result;
	}
	public E[][] multiplyMatrix(E[][] e1, E[][] e2){
		operator = '*';
		if(e1[0].length != e2.length){
			throw new RuntimeException("the matrices do not match");
		}
		result = (E[][])new Number[e1.length][e2[0].length];
		for(int i = 0; i < result.length; i++){
			for(int j = 0; j < result[0].length; j++){
				result[i][j] = zero();
				for(int k = 0; k < e1[0].length; k++){
					result[i][j] = add(multiply(e1[i][k], e2[k][j]), result[i][j]);
				}
			}
		}
		return result;
	}
	public static void printMatrix(Number[][] n1, Number[][] n2, char operator, Number[][] result){
		for(int i = 0; i < n1.length; i++){
			for(int j = 0; j < n1[0].length; j++){
				System.out.print(" " + n1[i][j]);
			}
			if(i == n1.length / 2)
				System.out.print("  " + operator + " ");
			else 
				System.out.print("    ");
			
			for(int j = 0; j < n2[0].length; j++){
				System.out.print(" " + n2[i][j]);
			}
			if(i == n2.length / 2)
				System.out.print("  =  ");
			else 
				System.out.print("     ");

			for(int j = 0; j < result[0].length; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	protected abstract E add(E e1, E e2);
	protected abstract E multiply(E e1, E e2);
	protected abstract E zero();
}

class Rational extends Number implements Comparable<Rational>{
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
