package com.day14.task6;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFS {
	int V;
	LinkedList<Integer> list[];
	
	@SuppressWarnings("unchecked")
	public GraphDFS(int V) {
		this.V=V;
		list=new LinkedList[V];
		for(int i=0;i<V;i++) {
			 list[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int v, int w) {
		list[v].add(w);
		list[w].add(v);
	}
	public void dfs(int v) {
		boolean[] visited=new boolean[V];
		dfsUtil(v,visited);
	}
	
	private void dfsUtil(int v, boolean[] visited) {
		visited[v]=true;
		System.out.print(v+" ");
		
		Iterator<Integer> it = list[v].iterator();
		while(it.hasNext()) {
			int n=it.next();
			if(!visited[n])
				dfsUtil(n,visited);
		}
	}
	public void printGraph() {
		for(int i=0;i<list.length;i++) {
			System.out.print("Vertex "+i+" is connected to: ");
			for(int j=0;j<list[i].size();j++) {
				System.out.print(list[i].get(j)+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		GraphDFS g = new GraphDFS(4);
	
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.printGraph();
		System.out.println("from vertex 2");
		g.dfs(2);
	}
}