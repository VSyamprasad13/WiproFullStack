package day12.task6;

import java.util.Stack;

public class StackSequenceCheck {

	public static void main(String[] args) {
		Stack<Integer> s=new Stack<Integer>();
		s.push(3);
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(5);
		
		int[] sequence= {1,2,6};
		boolean checker = sequenceChecker(s, sequence);
		System.out.println(checker);
	}
	public static boolean sequenceChecker(Stack<Integer> stack,int[] sequence) {
		int seq=0;
		while(!stack.isEmpty() && seq<sequence.length) {
			int stackTop=stack.pop();
			if(stackTop==sequence[seq]) {
				seq++;
			}
		}
		return (seq==sequence.length) && stack.isEmpty();
	}

}
