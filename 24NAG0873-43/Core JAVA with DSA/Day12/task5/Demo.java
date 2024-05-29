package day12.task5;

public class Demo {
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(2);
		list.insert(3);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		System.out.println("Original list");
		list.display();
		System.out.println("After removing duplicates");
		list.removeDuplicates();
		list.display();
	}
}
