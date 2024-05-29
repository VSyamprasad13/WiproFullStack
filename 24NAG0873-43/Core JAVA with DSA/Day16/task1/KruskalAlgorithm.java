package com.day16.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge>{
	int src, dest, weight;

	@Override
	public int compareTo(Edge compareEdge) {
		return this.weight-compareEdge.weight;
	}

	public Edge(int src, int dest, int weight) {
		super();
		this.src = src;
		this.dest = dest;
		this.weight = weight;		
		}
		
}
	
class Disjointset{
	int[] parent;
	
	public Disjointset(int size) {
		parent=new int[size];
		for(int i=0;i<size;i++) {
			parent[i]=i;
		}
	}
	public int find(int vertex) {
		if(parent[vertex]!=vertex) {
			parent[vertex]=find(parent[vertex]);
		}
		return parent[vertex];
	}
	public void union(int x,int y) {
		int rootX=find(x);
		int rootY=find(y);
		
		parent[rootX]=rootY;		
	}
}
public class KruskalAlgorithm {
	public List<Edge> kruskalMST(List<Edge> edges,int vertices) {
		List<Edge> mst= new ArrayList<>();
		
		Disjointset set = new Disjointset(vertices);
		
		Collections.sort(edges);
		for(Edge edge:edges) {
			if(set.find(edge.src) != set.find(edge.dest)) {
				mst.add(edge);
				set.union(edge.src, edge.dest);
			}
		}
		return mst;
			
	}
	
	public static void main(String[] args) {
		List<Edge> list = new ArrayList<>();
		
		list.add(new Edge(0,1,10));
		list.add(new Edge(0, 2, 6));
		list.add(new Edge(0, 3, 5));
		list.add(new Edge(1, 3, 15));
		list.add(new Edge(2, 3, 4));
		
		KruskalAlgorithm algorithm = new KruskalAlgorithm();
		List<Edge> mst = algorithm.kruskalMST(list, 4);
		System.out.println("Minimum spanning tree");
		for(Edge edge:mst) {
			System.out.println(edge.src+"--"+edge.dest+"=="+edge.weight);
		}
		
	}
	
}
