import java.util.ArrayList;

public class ArrayListSort {

	public static void main(String[] args) {
		ArrayList<String> s = new ArrayList<>();
		s.add("apple");
        s.add("zero");
        s.add("bear");
        s.add("nearby");
        s.add("apple");
        sort(s);
        System.out.println();
        ArrayList<Integer> in = new ArrayList<>();
        for(int i = 0; i < 10; i++){
        	in.add((int)(Math.random() * 10));
        }
        sort(in);
        System.out.println();
        removeDuplicates(s);
        System.out.println();
        removeDuplicates(in);
	}
	public static <E extends Comparable<E>> void sort(ArrayList<E> list){
		for(int i = 0; i < list.size() - 1; i++){
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(i).compareTo(list.get(j)) > 0){
					E e = list.get(i);
					list.set(i, list.get(j));
					list.set(j, e);
				}
			}
		}
		for(E a : list){
			System.out.print(a + " ");
		}
	}
	public static <E> void removeDuplicates(ArrayList<E> list){
		ArrayList<E> newList = new ArrayList<E>();
		for(int i = 0; i < list.size(); i++){
			if(! newList.contains(list.get(i))){
				newList.add(list.get(i));
			}
		}
		for(E a : newList){
			System.out.print(a + " ");
		}
	}
}