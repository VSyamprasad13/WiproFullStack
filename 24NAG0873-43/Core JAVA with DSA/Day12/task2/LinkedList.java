package day12.task2;


public class LinkedList <T>{
	class Node{
		T data;
		Node next;
		
		public Node(T data) {
			this.data=data;
			this.next=null;
		}
	}
		
	Node head;
	public LinkedList() {
		this.head = null;
	}
	
	public void insertAtBeginning(T data) {
		Node node = new Node(data);
		node.next=head;
		head=node;
	}
	
	public void insertAtEnd(T data) {
		Node node = new Node(data);
		if(head==null) {
			head=node;
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=node;
	}
	
	public void insert(int index, T data) {
		if(index<0)
			throw new IndexOutOfBoundsException("Invalid position: "+index);
		
		if(index==0) {
			insertAtBeginning(data);
			return;
		}
		
		Node node = new Node(data);
		Node current=head;
		for(int i=0;i<index-1 && current!=null;i++) {
			current=current.next;
		}
		if(current==null) {
			throw new IndexOutOfBoundsException("Invalid position: "+index);
		}
		node.next=current.next;
		current.next=node;
	}
	
	public void delete(T value) {
		if(head==null)
			return;
		if(head.data==value)
			head=head.next;
		Node current=head;
		while(current.next!=null) {
			if(current.next.data==value) {
				current.next=current.next.next;
				return;
			}
			current=current.next;
		}
	}
	public void deleteAtPos(int index) {
		if(head==null) 
			throw new IndexOutOfBoundsException("Invalid position");
		if(index==0) {
			head=head.next;
			return;
		}
		Node temp=head;
		Node prev=null;
		for(int i=1;i<=index;i++) {
			prev=temp;
			temp=temp.next;
		}
		prev.next=temp.next;
	}
	
	public void deleteAtBeginning() {
		if(head==null) throw new IndexOutOfBoundsException("Cannot delete a empty list");
		head=head.next;
	}
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public T findMiddle() {
		if(head==null || head.next==null)
			return head.data;
		Node slow=head;
		Node fast=head;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
}
