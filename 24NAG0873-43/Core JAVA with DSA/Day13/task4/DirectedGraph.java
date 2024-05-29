package com.day13.task4;

import java.util.ArrayList;

public class DirectedGraph {
	int V;
	ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(); 
	
	public DirectedGraph(int V) {
		this.V=V;
		for(int i=0;i<V;i++) {
			 list.add(new ArrayList<Integer>());
		}
	}
	public void addEdge(int v, int w) {
		list.get(v).add(w);
	}
	public boolean isCyclicAfterAddingEdge(int v,int w) {
		DirectedGraph temp=new DirectedGraph(V);
		
		for(int i=0;i<V;i++) {
			for(int n:list.get(i))
				temp.addEdge(i, n);
		}
		temp.addEdge(v, w);
		
		boolean[] visited=new boolean[V];
		if(isCyclicUtil(v,visited,temp)) {
			return true;
		}
		return false;
	}
	private boolean isCyclicUtil(int v, boolean[] visited, DirectedGraph temp) {
		if(visited[v])
			return true;
		
		visited[v]=true;
		for(int n:temp.list.get(v))
			if(isCyclicUtil(n, visited, temp))
				return true;
		visited[v]=false;
		return false;
	}
	
	public static void main(String[] args) {
		DirectedGraph g=new DirectedGraph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 0);
		
		System.out.println("Is adding edge 1->3 creating a cycle..? "+g.isCyclicAfterAddingEdge(1, 4));
		System.out.println("Is adding edge 3->1 creating a cycle..? "+g.isCyclicAfterAddingEdge(4, 0));
		
	}
}
