package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638_치즈 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N, M, answer;
	static int[][] map;
	static int[][] temp;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visit = new boolean[N][M];
			temp = new int[N][M];

			visit[0][0] = true;
			bfs();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j]) {
						temp[i][j] = 1;
					}
				}
			}

			boolean empty = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 1) {
						empty = false;
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int nr = i + dx[k];
							int nc = j + dy[k];
							if (temp[nr][nc] == 0)
								cnt++;
						}
						if (cnt >= 2) {
							temp[i][j] = 2;
						}
					}
				}
			}
			
//			for(int[] a: temp) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println("----------");
			
			if (empty)
				break;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 2) {
						map[i][j] = 0;
					}
				}
			}
			
			answer++;
		}

		System.out.println(answer);
	}

	public static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0));
		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dx[i];
				int nc = p.c + dy[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (!visit[nr][nc] && map[nr][nc] == 0) {
					visit[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
		}
	}

	public static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
