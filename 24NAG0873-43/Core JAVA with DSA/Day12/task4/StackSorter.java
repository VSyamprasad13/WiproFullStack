package day12.task4;

import java.util.Stack;

public class StackSorter {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		stack.push(1);
		stack.push(6);
		stack.push(3);
		stack.push(5);

		System.out.println("After sorting");
		sorter(stack);
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	
	public static void sorter(Stack<Integer> stack) {
		Stack<Integer> temp=new Stack<Integer>();
		
		while(!stack.isEmpty()) {
			int num=stack.pop();
			while(!temp.isEmpty() && temp.peek()>num) {
				stack.push(temp.pop());
			}
			temp.push(num);
		}
		while(!temp.isEmpty())
			stack.push(temp.pop());
	}

}
