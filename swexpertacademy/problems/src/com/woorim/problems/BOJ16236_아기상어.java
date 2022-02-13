package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236_아기상어 {
	static class Animal implements Comparable<Animal> {
		int r, c, size, dist, eatCnt, eatSec;

		public Animal(int r, int c, int size, int dist, int eatCnt, int eatSec) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
			this.eatCnt = eatCnt;
			this.eatSec = eatSec;
		}

		@Override
		public int compareTo(Animal o) {
			if (this.r < o.r)
				return -1;
			else if (this.r == o.r)
				if (this.c < o.c)
					return -1;
			return 1;
		}

	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int N, sharkStartR, sharkStartC;
	static int[][] map;
	static boolean[][] visit;
	static Animal shark;
	static PriorityQueue<Animal> eatPossible;
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 9) {
					sharkStartR = i;
					sharkStartC = j;
				} else if (val != 0) {
					map[i][j] = val;
				}
			}
		}
		solve();

		System.out.println(answer);
	}

	public static void solve() {
		boolean callMom = false;
		shark = new Animal(sharkStartR, sharkStartC, 2, 0, 0, 0);// 행, 열, 크기, 거리, 먹은개수, 먹은시간
		while (!callMom) {
			if (!searchFish()) {
				callMom = true;
				answer = shark.eatSec;
			}
		}
		return;
	}

	public static boolean searchFish() {
		boolean canEat = false;
		visit = new boolean[N][N];
		eatPossible = new PriorityQueue<>();
		bfs(shark);
		if (!eatPossible.isEmpty()) {
			canEat = true;
			Animal fish = eatPossible.poll();
			map[shark.r][shark.c] = 0;
			int newR = fish.r;
			int newC = fish.c;
			int size = shark.size;
			int dist = 0;
			int eatCnt = shark.eatCnt + 1;
			int eatSec = shark.eatSec + fish.dist;

			if (eatCnt == shark.size) {
				eatCnt = 0;
				size++;
			}
			shark = new Animal(newR, newC, size, dist, eatCnt, eatSec);

		}
		return canEat;
	}

	public static void bfs(Animal shark) {
		Queue<Animal> q = new LinkedList<>();
		q.offer(shark);
		visit[shark.r][shark.c] = true;
		int minDist = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Animal pos = q.poll();
			int r = pos.r;
			int c = pos.c;
			int dist = pos.dist;
			for (int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || shark.size < map[nr][nc])
					continue;
				if (!visit[nr][nc]) {
					visit[nr][nc] = true;
					// 좌표값이 1~6이고(물고기이고), 현재거리가 최소거리보다 작거나같으면
					if (map[nr][nc] != 0 && map[nr][nc] != 9 && dist + 1 <= minDist && map[nr][nc] < shark.size) {
						minDist = dist + 1;
						eatPossible.offer(new Animal(nr, nc, map[nr][nc], dist + 1, 0, 0));
					}
					q.offer(new Animal(nr, nc, map[nr][nc], dist + 1, 0, 0));
				}
			}
		}
	}

}
