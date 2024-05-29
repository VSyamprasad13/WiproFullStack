package day12.task3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SortQueue {

	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(2);
		q.offer(1);
		q.offer(4);
		q.offer(6);
		q.offer(3);
		System.out.println("Before sorting "+q);
		sort(q);
		System.out.println("After sorting:"+q);
		
	}
	public static void sort(Queue<Integer> que) {
		Stack<Integer> stack = new Stack<Integer>();
		
		while(!que.isEmpty()) {
			int temp=que.poll();
			while(!stack.isEmpty() && stack.peek()<temp) {
				que.add(stack.pop());
			}
			stack.push(temp);
		}
		
		while(!stack.isEmpty()) {
			que.add(stack.pop());
		}
		
	}

}
/* 
 * Steps:
 * Define a method sortQueue(Queue<Integer> queue) that takes the queue as input and sorts it.
 * Inside the sortQueue method, initialize a stack to store temporary values.
 *  While the queue is not empty, dequeue elements from the queue one by one.
 *   For each element dequeued from the queue, check if the stack is empty or if the element is greater than or equal to the top element of the stack. If so, push the element onto the stack.
 *  If the element is smaller than the top element of the stack, 
dequeue elements from the stack and enqueue them into the queue until the
stack is empty or the top element of the stack is smaller than the element being considered.
 * Once the element is correctly positioned in the stack, push it onto the stack.
 *  Repeat steps 3-6 until the queue is empty.
 *  Now, all elements are in the stack in ascending order.
Pop elements from the stack and enqueue them into the queue.
 * The queue will now contain sorted elements.

 */
