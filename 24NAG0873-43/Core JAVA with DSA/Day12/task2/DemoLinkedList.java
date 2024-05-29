package day12.task2;


public class DemoLinkedList {

	public static void main(String[] args) {
//		Inserting Integer values using generic
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtBeginning(10);
		list.insertAtBeginning(20);
		list.insert(0, 4);
		list.insertAtEnd(30);
		list.insert(3, 40);
		list.insert(4, 50);
		list.display();
		System.out.println(list.findMiddle());
	}

}
