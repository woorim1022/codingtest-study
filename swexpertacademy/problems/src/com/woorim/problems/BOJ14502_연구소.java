package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_연구소 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] map;
	static int[][] temp;
	static boolean[][] visit;
	static int N, M;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					// deepcopy
					for (int k = 0; k < N; k++) {
						System.arraycopy(map[k], 0, temp[k], 0, map[k].length);
					}

					temp[i][j] = 1;
					makeWall(1);
					temp[i][j] = 0;
				}
			}
		}

		System.out.println(answer);

	}

	public static void makeWall(int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0) {
					temp[i][j] = 1;
					makeWall(cnt + 1);
					temp[i][j] = 0;
				}
			}
		}
	}

	public static void bfs() {
		int[][] afterSpread = new int[N][M];
		;
		for (int k = 0; k < N; k++) {
			System.arraycopy(temp[k], 0, afterSpread[k], 0, temp[k].length);
		}

		Queue<Pos> q = new LinkedList<>();

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (temp[i][j] == 2)
					q.offer(new Pos(i, j));

		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || afterSpread[nr][nc] != 0)
					continue;
				afterSpread[nr][nc] = 2;
				q.offer(new Pos(nr, nc));
			}
		}

		int safe = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (afterSpread[i][j] == 0)
					safe++;

		answer = Math.max(answer, safe);
	}

	public static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
