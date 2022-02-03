package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_DFS와BFS3 {
	static int N, M, V;
	static int[][] arr;
	static boolean visit[];
	static ArrayList<Integer> dfs;
	static ArrayList<Integer> bfs;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
		arr = new int[N+1][N+1];
		dfs = new ArrayList<>();
		bfs = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[c][r] = 1; // 정점끼리 연결 여부 표시
			arr[r][c] = 1;
		}
		
		visit = new boolean[N+1];
		dfs(V, 0);
		
		visit = new boolean[N+1];
		bfs();
		

		for(int i = 0 ; i < dfs.size(); i++) {
			System.out.print(dfs.get(i) + " ");
		}
		System.out.println();
		for(int i = 0 ; i < bfs.size(); i++) {
			System.out.print(bfs.get(i) + " ");
		}
		
		
	}
	
	// 깊이우선 탐색, 더이상 탐색할 수 없을 때 까지 탐색하고 돌아와서 다음 탐색
	//재귀로 구현
	// visit[] 에 방문 여부 저장
	static private void dfs(int node, int cnt) {
		dfs.add(node);
		visit[node] = true;
		if(cnt == N) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(arr[node][i] == 1 && visit[i] == false) {
				dfs(i, cnt+1);
			}
		}
		return;
	}
	

	
	//넓이우선 탐색, 루트노드에서 시작해서 인접한 노드를 먼저 탐색
	//큐로 구현
		//큐가 비어있지 않은 동안 while문 반복
	static private void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		bfs.add(V);
		visit[V] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for (int i = 1; i <= N; i++) {
				if(arr[node][i] == 1 && visit[i] == false) {
					q.offer(i);
					visit[i] = true;
					bfs.add(i);
				}
			}
		}
		
	}
	
}
