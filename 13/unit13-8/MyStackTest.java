import java.util.ArrayList;
public class MyStackTest {

	public static void main(String[] args) {
		MyStack s1 = new MyStack();
		s1.push(1);
		s1.push(2);
		System.out.println(s1);
		try{
			MyStack s2 = (MyStack)s1.clone();
			System.out.println(s2 + " " + (s1.getList() == s2.getList()));
		}catch(CloneNotSupportedException ex){}
	}
}

class MyStack implements Cloneable{
    private ArrayList<Object> list = new ArrayList<Object>();

    public boolean isEmpty(){
        return list.isEmpty();
    }
    public ArrayList<Object> getList(){
    	return list;
    }
    public int getSize(){
        return list.size();
    }

    public Object peek(){
        return list.get(list.size()-1);
    }

    public Object pop(){
        Object o = list.get(list.size()-1);
        list.remove(getSize()-1);
        return o;
    }

    public void push(Object o){
        list.add(o);
    }
    @Override
    public String toString(){
    	return "stack: " + list.toString();
    }
    @Override
    public Object clone() throws  CloneNotSupportedException{
    	MyStack tstack = (MyStack)super.clone();
    	tstack.list = (ArrayList<Object>) list.clone();
    	return tstack;
    }
}
