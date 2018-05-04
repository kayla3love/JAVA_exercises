import java.util.Arrays;

public class MyStringTest1 {
	public static void main(String[] args){
		MyString1 s = new MyString1(new char[]{'A','B','a','c'});
		System.out.println(s.charAt(0));
		System.out.println(s.length());
		System.out.println(s.substring(0,2).charAt(2));
		System.out.println(s.toLowerCase().charAt(1));
	}

}
class MyString1{
	private final char[] value;
	public MyString1(char[] chars){
		value = Arrays.copyOf(chars, chars.length);
	}
	public char charAt(int index){
		if ((index < 0) || (index >= value.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
		return value[index];
	}
	public int length(){
		return value.length;
	}
	public MyString1 substring(int begin, int end){
		char[] c = new char[end - begin + 1];
		for(int i = begin; i <= end; i++){
			c[i] = value[i];
		}
		MyString1 my = new MyString1(c);
		return my;
	}
	public MyString1 toLowerCase(){
		for(int i = 0; i < value.length; i++){
			if(value[i] >= 'A' && value[i] <= 'Z'){
				value[i] = (char)(value[i]  + 'a' - 'A');
			}
		}
		return this;
	}
}