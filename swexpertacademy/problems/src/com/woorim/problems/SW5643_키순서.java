package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class SW5643_키순서 {
	static int N, M, adj[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			
		
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1; // from 보다 to가 키가 크다
				
			}
			
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				if(gtBFS(i)+ltBFS(i) == N-1) {
					++ans;
				}
			}
			

			System.out.print("#" + t + " " + ans);
		}
	}
	
	static private int gtBFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && adj[cur][i] == 1) {
					queue.offer(i);
					visited[i] = true;
					++cnt;
				}
			}
		}
		return cnt;
	}
	
	static private int ltBFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0; i <= N; i++) {
				if(!visited[i] && adj[i][cur] == 1) {
					queue.offer(i);
					visited[i] = true;
					++cnt;
				}
			}
		}
		return cnt;
	}
	
	
	
	
}
