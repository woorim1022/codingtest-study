package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724_연결요소의개수 {
	static int N, M, answer;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1 && !visit[i]) {
					dfs(i);
					answer++;
				}
				
			}
			if(!visit[i]) {
				visit[i] = true;
				answer++;
			}

		}
		System.out.println(answer);
	}

//	dfs
	public static void dfs(int node1) {
		visit[node1] = true;
		for (int i = 1; i <= N; i++) {
			if (map[node1][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}
