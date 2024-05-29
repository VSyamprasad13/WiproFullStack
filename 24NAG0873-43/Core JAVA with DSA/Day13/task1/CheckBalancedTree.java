package com.day13.task1;


class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class CheckBalancedTree {
	Node root;
	public CheckBalancedTree() {
		this.root=null;
	}
	public boolean isBalanced(Node root) {
		if(root==null)
			return true;
		if((height(root.left)-height(root.right)>1))
			return false;
		
		return isBalanced(root.left) && isBalanced(root.right);
	}
	private int height(Node node) {
		if(node==null)
			return 0;
		return Math.abs(1+Math.max(height(node.left), height(node.right)));
	}
	public static void main(String[] args) {
		CheckBalancedTree ch= new CheckBalancedTree();
		Node node1= new Node(1);
		node1.left=new Node(2);
		node1.right=new Node(3);
		node1.left.left=new Node(4);
		node1.left.right=new Node(5);
		node1.right.left=new Node(6);
		node1.right.right=new Node(7);
		
		System.out.println("Is the tree balanced: "+ch.isBalanced(node1));
		
		Node node2= new Node(10);
		node2.left=new Node(20);
		node2.right=new Node(30);
		node2.left.left=new Node(40);
		node2.right.left=new Node(50);
		node2.left.left.left=new Node(60);
		System.out.println("Is the tree balanced: "+ch.isBalanced(node2));
	}
}
