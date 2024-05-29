package com.day15.task2;

import java.util.*;

public class DijkstraAlgorithm {
	private static class Node implements Comparable<Node>{
		int vertex;
		int distance;
		
		public Node(int vertex, int distance){
			this.vertex=vertex;
			this.distance=distance;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}
		public static void dijkstra(int[][] graph,int source) {
			int V=graph.length;
			int[] distance=new int[V];
			
			boolean[] visited=new boolean[V];
			PriorityQueue<Node> queue = new PriorityQueue<Node>();
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[source]=0;
			queue.add(new Node(source, 0));
			
			while(!queue.isEmpty()) {
				Node node=queue.poll();
				int u=node.vertex;
				if(visited[u]) continue;
				visited[u]=true;
				
				for(int v=0;v<V;v++) {
					if(!visited[v] && graph[u][v]!=0 && distance[u]+graph[u][v]<distance[v]) {
						distance[v]=distance[u]+graph[u][v];
						queue.add(new Node(v,distance[v]));
					}
				}
			}
			printSolution(distance,source);
		}
		
	private static void printSolution(int[] distance, int source) {
		System.out.println("Vertex\tDistance from the source "+source);
		for(int i=0;i<distance.length;i++) {
			System.out.print(i+"\t"+distance[i]);
		}
	}
	public static void main(String[] args) {
		int[][] graph= new int[][] {
			{0,10,20,0,0},
			{10,0,0,50,10},
			{20,0,0,20,33},
			{0,50,20,0,2},
			{0,10,33,2,0}
		};
		dijkstra(graph, 0);
	}
}
