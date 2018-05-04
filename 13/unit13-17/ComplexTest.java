import java.util.*;
public class ComplexTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first complex number: ");
		String complex1 = input.nextLine();
		Complex c1 = setComplex(complex1);
		System.out.println("Enter the second complex number: ");
		String complex2 = input.nextLine();
		Complex c2 = setComplex(complex2);
		System.out.println("(" + c1 + ") " + "+" + " (" + c2 + ") " + "= " + c1.add(c2));
		

	}
	public static Complex setComplex(String complexString){
		String[] a = complexString.split(" ");
		double c11 = Double.parseDouble(a[0]);
		double c12 = Double.parseDouble(a[1]);
		return new Complex(c11, c12);
	}

}
