package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234_인구이동 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, L, R, total, cnt;
	static int[][] A;
	static int[][] alliance;
	static int[][] temp;
	static boolean[][] visit;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		alliance = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				alliance[i][j] = -1;
			}
		}

		while (true) {
			boolean move = false;
			temp = new int[N][N];
			for (int k = 0; k < N; k++) {
				System.arraycopy(A[k], 0, temp[k], 0, A[k].length);
			}
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						total = A[i][j];
						cnt = 1;
						alliance[i][j] = i * N + j;
						visit[i][j] = true;
						move = bfs(i, j, move);
					}
				}
			}
			if (!move)
				break;
			answer++;
			for (int k = 0; k < N; k++) {
				System.arraycopy(temp[k], 0, A[k], 0, temp[k].length);
			}

		}

		System.out.println(answer);
	}

	public static boolean bfs(int curR, int curC, boolean move) {
		int allNum = curR * N + curC; // 연합번호

		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(curR, curC));
		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) { // 사방탐색
				int nr = p.r + dx[i];
				int nc = p.c + dy[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				int diff = Math.abs(A[p.r][p.c] - A[nr][nc]);
				if (diff < L || diff > R || visit[nr][nc])
					continue;
				move = true;
				visit[nr][nc] = true;
				total += A[nr][nc];
				cnt++;
				alliance[nr][nc] = allNum; // 연합번호 부여
				q.offer(new Pos(nr, nc));
			}
		}
		if (move) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (alliance[i][j] == allNum) {
						temp[i][j] = total / cnt;
					}
				}
			}
		}

		return move;
	}

	public static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
