
public class TestStackOfIntegers {

	public static void main(String[] args) {
		StackOfIntegers stack = new StackOfIntegers();
		for(int i = 0; i < 10; i++){
			stack.push(i);
		}
		while(!stack.empty()){
			System.out.print(stack.pop() + " ");
		}

	}

}
class StackOfIntegers{
	private int size;
	private int[] elements;
	
	StackOfIntegers(){
		this(5);
	}
	StackOfIntegers(int sizeOfStack){
		elements = new int[sizeOfStack];
	}
	public int getSize(){
		return size;
	}
	public boolean empty(){
		return size == 0;
	}
	public int peek(){
		return elements[size - 1];
	}
	public void push(int value){
		if(size >= elements.length){
			int[] temp = new int[elements.length + 1];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = value;
	}
	public int pop(){
		return elements[--size];
	}
}
