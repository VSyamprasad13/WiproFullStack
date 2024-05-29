package day12.task5;
/*
 * Algorithm to remove the duplicates in linked list:
 * step 1: Start with the head node first
 * step 2: Traverse the list one at a time
 * step 3: For each node check if the next node exists and its value equal to current node value
 * step 4: If duplicates occurs adjust the next node by using pointers
 * step 5: Repeat the process until the entire list is traversed 
 * */
class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
}

public class LinkedList{
	Node head;
	public LinkedList() {
		this.head=null;
	}
	public void insert(int data) {
		Node node=new Node(data);
		if(head==null) {
			head=node;
			return;
		}
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=node;
	}
	public void removeDuplicates() {
		Node current=head;
		
		while(current!=null && current.next!=null) {
			if(current.data==current.next.data)
				current.next=current.next.next;
			else 
				current=current.next;
		}
	}
	
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}

