import java.util.*;
public class ComparableCircleTest {

	public static void main(String[] args) {
		ComparableCircle circle1 = new ComparableCircle(3.0);
		ComparableCircle circle2 = new ComparableCircle();
		System.out.println(circle1.compareTo(circle2));
	}
}

