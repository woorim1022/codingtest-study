package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 출력

public class BOJ2667_단지번호붙이기 {
	static int[] dr = new int[] { -1, 0, 1, 0 };
	static int[] dc = new int[] { 0, -1, 0, 1 };
	static int N;
	static int danjiCnt;
//	static int[] answer;
	static ArrayList<Integer> answer;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		answer = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}

		// sort() 말고 정렬하는 다른 방법 생각해보기
		Collections.sort(answer);

		System.out.println(danjiCnt);
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}

	}

	public static void bfs(int startR, int startC) {
		int housecnt = 0;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(startR, startC));
		visit[startR][startC] = true;
		housecnt++;
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			int curR = pos.row;
			int curC = pos.col;
			for (int i = 0; i < 4; i++) {
				int nR = curR + dr[i];
				int nC = curC + dc[i];
				if (nR < 0 || nC < 0 || nR >= N || nC >= N)
					continue;
				if (map[nR][nC] == 1 && !visit[nR][nC]) {
					visit[nR][nC] = true;
					housecnt++;
					q.offer(new Pos(nR, nC));
				}
			}
		}

		// 현재 단지에 포함된 집의 개수
		answer.add(housecnt);
		// 단지 수 1 증가
		danjiCnt++;
		return;
	}

	public static class Pos {
		int row, col;

		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
