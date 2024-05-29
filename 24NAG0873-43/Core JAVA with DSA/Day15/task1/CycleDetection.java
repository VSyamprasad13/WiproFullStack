package com.day15.task1;

class UnionFind{
	int[] parent;
	public UnionFind(int n) {
		parent=new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
	}
	public int find(int x) {
		if(parent[x]!=x)
			parent[x]=find(parent[x]);
		return parent[x];
	}
	public void union(int x,int y) {
		int rootX=find(x);
		int rootY=find(y);
		
		if(rootX==rootY) {
			System.out.println("Cycle dtected between "+x+" and "+y);
			return;
		}
		parent[rootY]=rootX;
		
	}
}
public class CycleDetection {

	public static void main(String[] args) {
		int[][] edges= {{0,1},{1,2},{2,0}};
		
		UnionFind find = new UnionFind(3);
		for(int[]edge:edges) {
			int u=edge[0];
			int v=edge[1];
			find.union(u, v);
		}
	}

}
