package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0: 이동가능, 1: 벽
// 벽을 한 개 까지 부수고 이동 가능
// 최단 경로 구하라


// 스택오버플로우 발생
// JVM은 각 쓰레드의 각 스택에게 메모리를 할당해줍니다. 
//그리고 메소드를 부르려는 시도로 메모리가 꽉찰 경우 JVM은 에러를 발생시킵니다. 
//스택오버플로우 에러는 사용가능한 메모리가 더이상 없다는 뜻입니다.

//재귀의 깊이가 너무 깊어져서 스택 오버플로우가 일어난듯

// 메모이제이션을 활용해 재귀함수 호출 횟수를 줄여보자, 백트래킹

// 시간초과 ㅠㅠ

// bfs로 풀어보기
// bfs는 끊을 수 있어서 시간초과가 안날 수 있음
// 가중치가없는 최단거리이므로 BFS 로 풀어야합니다.
public class BOJ2206_벽부수고이동하기 {
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	static int[][] map;
	static int[][] visit;
	static int[][] memo;
	static int crush = 0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		memo = new int[N+1][M+1];
		visit = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				memo[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j-1) - '0';
			}
		}
		solve(1, 1, 1);
		System.out.println((min == Integer.MAX_VALUE)?-1:min);
	}
	private static void solve(int row, int col, int cnt) {
		if(row == N && col == M) {
			min = Math.min(min, cnt);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nr = row + dx[i];
			int nc = col + dy[i];
			if(nr < 1 || nr > N || nc < 1 || nc > M) continue;
			if(visit[nr][nc] == 1) continue;
			if(cnt+1 > memo[nr][nc]) continue;
			if(map[nr][nc]==0 || (map[nr][nc]==1 && crush == 0)) {
				if((map[nr][nc]==1) && (crush==0)) {
					crush = 1;
				}
				memo[nr][nc] = cnt + 1;
				solve(nr, nc, cnt+1);
				if(map[nr][nc]==1)crush = 0;
				visit[nr][nc] = 0;
			}
		}
	}

}
