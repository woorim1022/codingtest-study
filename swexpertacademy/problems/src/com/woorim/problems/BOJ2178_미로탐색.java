package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178_미로탐색 {
	static int[] dr = new int[] { -1, 0, 1, 0 };
	static int[] dc = new int[] { 0, 1, 0, -1 };
	static int N, M;
	static int[][] miro;
	static boolean[][] visit;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);

		answer = Integer.MAX_VALUE;
		miro = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = line.charAt(j) - '0';
			}
		}

//		dfs(1, 0, 0);
		bfs();

		System.out.println(answer);

	}

	public static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(0, 0, 1));
		visit[0][0] = true;
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			int curR = pos.row;
			int curC = pos.col;
			int cnt = pos.cnt;
			if (curR == N - 1 && curC == M - 1) {
				answer = cnt;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nR = curR + dr[i];
				int nC = curC + dc[i];
				if (nR < 0 || nC < 0 || nR >= N || nC >= M)
					continue;
				// 방문 안했고 && 1이면 이동
				if (visit[nR][nC] == false && miro[nR][nC] == 1) {
					visit[nR][nC] = true;
					q.offer(new Pos(nR, nC, cnt + 1));
				}
			}
		}

		return;
	}

	public static class Pos {
		int row, col, cnt;

		public Pos(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}

	}

//  dfs - 시간초과
//	public static void dfs(int cnt, int curR, int curC) {
//		//0,0 시작점으로 dfs 탐색 시작
//		//사방탐색 하면서 miro[nc][nr]==1 이고 방문 안했으면 visit표시하고 재귀로 이동
//		//더 이상 갈 곳 없으면 리턴하고 부모함수로 돌아감
//		//기저조건 : 현재 위치가 (n-1,m-1)이면 현재 answer값과 대소비교 후 리턴
//		if(curR == N-1 && curC == M-1) {
//			answer = Math.min(answer, cnt);
//			return;
//		}
//		for(int i = 0; i < 4; i++) {
//			int nR = curR + dr[i];
//			int nC = curC + dc[i];
//			if(nR < 0 || nC < 0 || nR >= N || nC >= M) continue;
//			//방문 안했고 && 1이면 이동
//			if(visit[nR][nC] == false && miro[nR][nC] == 1) {
//				visit[nR][nC] = true;
//				dfs(cnt + 1, nR, nC);
//				visit[nR][nC] = false;
//			}
//		}
//		return;
//	}
}
