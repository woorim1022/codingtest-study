package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18809_Gaaaaaaaaarden {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static final int GREEN = 3;
	static final int RED = 4;
	static final int FLOWER = 5;
	static int N, M, G, R, answer;
	static int[][] map;
	static int[] visit;
	static ArrayList<Pos> nutritionPos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		nutritionPos = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					nutritionPos.add(new Pos(i, j, 0));
				}
			}
		}

		visit = new int[nutritionPos.size()];
		chooseGreen(G, 0);
		System.out.print(answer);
	}

	public static void chooseGreen(int g, int start) {
		// 조합을 사용해서 초록색 배양액을 뿌릴 땅을 고른다
		if (g == 0) {
			chooseRed(R, 0);
			return;
		}
		for (int i = start; i < nutritionPos.size(); i++) {
			if (visit[i] == 0) {
				visit[i] = GREEN;
				chooseGreen(g - 1, i);
				visit[i] = 0;
			}
		}
	}

	public static void chooseRed(int r, int start) {
		// 초록색 땅을 다 고른 후에 남은 땅으로 조합을 사용해서 빨간색 배양액을 뿌릴 땅을 고른다
		if (r == 0) {
			spread();
			return;
		}
		for (int i = start; i < nutritionPos.size(); i++) {
			if (visit[i] == 0) {
				visit[i] = RED;
				chooseRed(r - 1, i);
				visit[i] = 0;
			}
		}
	}

	public static void spread() {
		int flowerCnt = 0;
		Queue<Pos> q = new LinkedList<>();
		Pair[][] state = new Pair[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				state[i][j] = new Pair();
			}
		}

		for (int i = 0; i < visit.length; i++) {
			Pos p = nutritionPos.get(i);
			if (visit[i] == GREEN) {
				state[p.r][p.c] = new Pair(0, GREEN);
				q.offer(new Pos(p.r, p.c, GREEN));
			} else if (visit[i] == RED) {
				state[p.r][p.c] = new Pair(0, RED);
				q.offer(new Pos(p.r, p.c, RED));
			}
		}

		while (!q.isEmpty()) {
			Pos pos = q.poll();
			int r = pos.r;
			int c = pos.c;
			int curtime = state[r][c].time;
			int curtype = state[r][c].type;
			if (state[r][c].type == FLOWER)
				continue;
			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dx[i];
				int nc = pos.c + dy[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0)
					continue;
				if (state[nr][nc].type == 0) {
					state[nr][nc] = new Pair(curtime + 1, curtype);
					q.offer(new Pos(nr, nc, curtype));
				} else if (state[nr][nc].type == GREEN) {
					if (curtype == RED && state[nr][nc].time == curtime + 1) {
						state[nr][nc].type = FLOWER;
						flowerCnt++;
					}
				} else if (state[nr][nc].type == RED) {
					if (curtype == GREEN && state[nr][nc].time == curtime + 1) {
						state[nr][nc].type = FLOWER;
						flowerCnt++;
					}
				}
			}
		}
		answer = Math.max(answer, flowerCnt);
	}

	public static class Pos {
		int r, c, color;

		public Pos(int r, int c, int color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}

	public static class Pair {
		int time;
		int type;

		public Pair() {
		}

		public Pair(int time, int type) {
			this.time = time;
			this.type = type;
		}
	}
}
