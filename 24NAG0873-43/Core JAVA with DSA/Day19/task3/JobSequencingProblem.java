package com.day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Job{
	int id;
	int deadline;
	int profit;
	public Job(int id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
	
}

public class JobSequencingProblem {
	public static List<Job> jobSequencing(List<Job> jobs){
		Collections.sort(jobs,(a,b)-> b.profit-a.profit);
		
		int maxDeadline=0;
		for(Job job:jobs) {
			maxDeadline=Math.max(maxDeadline, job.deadline);
		}
		
		boolean[] slots=new boolean[maxDeadline];
		
		List<Job> list = new ArrayList<>();
		
		for(Job job:jobs) {
			for(int i=Math.min(maxDeadline, job.deadline)-1;i>=0;i--) {
				if(!slots[i]) {
					slots[i]=true;
					list.add(job);
					break;
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		List<Job> jobs=new ArrayList<Job>();
		jobs.add(new Job(1, 4, 20));
		jobs.add(new Job(2, 1, 10));
		jobs.add(new Job(3, 1, 40));
		jobs.add(new Job(4, 1, 30));
		
		List<Job> list = jobSequencing(jobs);
		
		for(Job job:list)
			System.out.println("Job "+job.id+" with profit: "+job.profit+" and deadline "+job.deadline);
	}
}
