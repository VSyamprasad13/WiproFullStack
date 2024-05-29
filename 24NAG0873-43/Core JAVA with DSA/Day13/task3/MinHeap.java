package com.day13.task3;

public class MinHeap {
	int[] heap;
	int size;
	int capacity;
	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.size=0;
		this.heap=new int[capacity+1];
	}
	
	public void insert(int data) {
		if(size>=capacity) {
			System.out.println("Heap overflow");
			return;
		}
		size++;
		heap[size]=data;
		int current=size;
		while(current>1 && (heap[current])<heap[parent(current)]) {
			swap(current,parent(current));
			current=parent(current);
		}
	}
	public int extractMin() {
		if(size==0) {
			System.out.println("Heap underflow");
			return -1;
		}
		int min=heap[1];
		heap[1]=heap[size];
		size--;
		minHeapify(1);
		return min;
	}
	public int getMin() {
		if(size==0) {
			System.out.println("Heap is empty");
			return -1;
		}
		return heap[1];
	}

	private void minHeapify(int pos) {
		int left=leftChild(pos);
		int right=rightChild(pos);
		int smallest=pos;
		if(left<=size && heap[left]<heap[pos])
			smallest=left;
		if(right<=size && heap[right]<heap[smallest])
			smallest=right;
		
		if(smallest!=pos) {
			swap(pos,smallest);
			minHeapify(smallest);
		}
		
	}

	private int rightChild(int pos) {
		return 2*pos+1;
	}

	private int leftChild(int pos) {
		return 2*pos;
	}

	private void swap(int i, int j) {
		int temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}

	private int parent(int pos) {
		
		return pos/2;
	}
	
	
	public static void main(String[] args) {
		MinHeap mh=new MinHeap(10);
		mh.insert(3);
		mh.insert(2);
		mh.insert(1);
		mh.insert(15);
		mh.insert(5);
		mh.insert(4);
		
		System.out.println("Minimum element..:"+mh.getMin());
		System.out.println("Extracted min element...:"+mh.extractMin());
		System.out.println("Minimum element after extraction..:"+mh.getMin());
	}
}
