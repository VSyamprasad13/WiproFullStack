package com.day14.task5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
	int V;
	LinkedList<Integer> adjList[];
	
	@SuppressWarnings("unchecked")
	public GraphBFS(int V) {
		this.V=V;
		adjList=new LinkedList[V];
		for(int i=0;i<V;i++) {
			adjList[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v);
	}
	
	public void bfs(int v) {
		boolean[] visited=new boolean[V];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visited[v]=true;
		queue.add(v);
		
		while(!queue.isEmpty()) {
			v=queue.poll();
			System.out.print(v+" ");
			
			Iterator<Integer> it = adjList[v].iterator();
			while(it.hasNext()) {
				int n=it.next();
				if(!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
//			for(int n: adjList[v])
//				if(!visited[n]) {
//					visited[n]=true;
//					queue.add(n);
//				}
		}
	}
	
	public void printGraph() {
		for(int i=0;i<adjList.length;i++) {
			System.out.print("Vertex "+i+" is connected to: ");
			for(int j=0;j<adjList[i].size();j++) {
				System.out.print(adjList[i].get(j)+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		GraphBFS g = new GraphBFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.printGraph();
		System.out.println("from vertex 2");
		g.bfs(2);
	}
}