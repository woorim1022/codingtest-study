package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1681_해밀턴순환회로 {

	static int N, min;
	static int [][] map;
	static boolean [] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true;
		dfs(0,0,0);
		System.out.println(min);

	}
	private static void dfs(int cnt, int cur, int cost) {
		
		if(min < cost) return ;
			
		if(cnt == N-1) {
			if(map[cur][0] == 0) return ;
			if(cost+map[cur][0] < min)
				min = cost+map[cur][0];
			return ;
		}
		
		for(int i = 0; i < N; i++) {
			if(map[cur][i] == 0) continue;
			if(visited[i]) continue;
			visited[i] = true;
			dfs(cnt+1, i, cost+map[cur][i]);
			visited[i] = false;
		}
	}

}
