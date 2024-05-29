package com.day19;

public class TravellingSoldier {

	public static void main(String[] args) {
		int[][] dist= {
				{0,10,15,20},
				{10,0,35,25},
				{15,35,0,30},
				{20,25,30,0}
		};
		System.out.println("The minimum cost is: "+tsp(dist));
	}

	private static int tsp(int[][] dist) {
		int n=dist.length;
		int VISITED_ALL=(1<<n)-1;
		int[][] dp=new int[1<<n][n];
		for(int i=0;i<(1<<n);i++)
			for(int j=0;j<n;j++) 
				dp[i][j]=Integer.MAX_VALUE;
		
		dp[1][0]=0;
		
		for(int mask=1;mask<(1<<n);mask++)
			for(int i=0;i<n;i++) {
				if((mask & (1<<i))==0)
					continue;
				for(int j=0;j<n;j++)
					if((mask & (1<<j))==0 && dist[i][j]!=0)
						dp[mask][j]=Math.min(dp[mask|(1<<j)][j],dp[mask][i]+dist[i][j]);
			}
		int minCost=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
			if(dist[i][0]!=0)
				minCost=Math.min(minCost,dp[VISITED_ALL][i]+dist[i][0]);
		
		return minCost;
	}

}
