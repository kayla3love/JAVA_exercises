import java.util.ArrayList;

public class HeapTest{

	public static void main(String[] args) {
		Integer[] lists = new Integer[10];
		for(int i = 0; i < lists.length; i++) {
			lists[i] = (int)(Math.random() * 100);
		}
		HeapSort.heapSort(lists);
		for(int i = 0; i < lists.length; i++)
			System.out.print(lists[i] + " ");
	}

}
class HeapSort{
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		Heap<E> heap = new Heap<>(list);
		for(int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}
}
class Heap<E extends Comparable<E>>{
	private ArrayList<E> list = new ArrayList<>();
	public Heap() {
		
	}
	public Heap(E[] newObject) {
		for(int i = 0; i < newObject.length; i++) {
			this.add(newObject[i]);
		}
	}
	public void add(E newObject) {
		list.add(newObject);
		int currentNum = list.size() - 1;
		int fatherNum = (currentNum - 1) / 2;
		while((list.get(currentNum).compareTo(list.get(fatherNum))) > 0) {
			E temp = list.get(currentNum);
			list.set(currentNum, list.get(fatherNum));
			list.set(fatherNum, temp);
			currentNum = fatherNum;
			fatherNum = (currentNum - 1) / 2;
		}
	}
	public E remove() {
		E deleteE = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		int currentNum = 0;
	
		while(list.size() > currentNum) {
			int leftSonNum = 2 * currentNum + 1;
			int maxNum = leftSonNum;
			E maxE = list.get(currentNum);
			if(list.size() > leftSonNum) {                     //注意 这里一定不能取等号
				int rightSonNum = 2 * currentNum + 2;
				maxE = list.get(leftSonNum);
				if(list.size() > rightSonNum && (list.get(rightSonNum).compareTo(list.get(leftSonNum)) > 0)) {
					maxE = list.get(rightSonNum);
					maxNum = rightSonNum;
				}
			}
			if(list.get(currentNum).compareTo(maxE) < 0) {
				E temp = list.get(currentNum);
				list.set(currentNum, list.get(maxNum));
				list.set(maxNum, temp);
			}
			currentNum = maxNum;
		}
		for(E a : list) {
			System.out.print(a + " ");
		}
		System.out.println();
		return deleteE;
	}
	public int getSize() {
		return list.size();
	}
}