package day12.task7;

class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
}
public class MergeTwoLinkedLists {
	
	public static void main(String[] args) {
		Node l1=new Node(1);
		l1.next=new Node(3);
		l1.next.next=new Node(5);
		
		Node l2=new Node(2);
		l2.next=new Node(4);
		l2.next.next=new Node(6);
		System.out.println("List1:");
		print(l1);
		System.out.println("list2:");
		print(l2);
		
		Node lists = mergeLists(l1, l2);
		System.out.println("Merged lists");
		print(lists);
	}
	public static Node mergeLists(Node l1, Node l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		Node head;
		if(l1.data<l2.data) {
			head=l1;
			l1=l1.next;
		}else {
			head=l2;
			l2=l2.next;
		}
		
		Node current=head;
		while(l1!=null && l2!=null) {
			if(l1.data<l2.data) {
				current.next=l1;
				l1=l1.next;
			}else {
				current.next=l2;
				l2=l2.next;
			}
			current=current.next;
		}
		current.next=(l1!=null)?l1:l2;
		
		return head;
	}
	public static void print(Node head) {
		Node current=head;
		while(current!=null) {
			System.out.print(current.data);
			current=current.next;
		}
		System.out.println();
	}

}
