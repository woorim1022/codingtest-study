package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012_유기농배추 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int M, N, K, ans;
	static int[][] land;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			land = new int[N][M];
			visit = new boolean[N][M];
			ans = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				land[r][c] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (land[i][j] == 1 && !visit[i][j]) {
						bfs(i, j);
					}
				}
			}
			System.out.println(ans);
		}
	}

	public static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c));
		visit[r][c] = true;
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (land[nr][nc] == 1 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
		}
		ans++;
	}

	public static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
