package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산
public class BOJ2468_안전영역 {
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int N;
	static int[][] map;
	static int[][] mapCopy;
	static int[][] visit;
	static int max = 0;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int h = 1; h < 101; h++) {
			mapCopy = new int[N][N];
			cnt = 0;
			visit = new int[N][N];
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visit[i][j] = 0;
					if(map[i][j] <= h) {
						mapCopy[i][j] = 0;
					}else{
						mapCopy[i][j] = 1;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mapCopy[i][j] == 1 && visit[i][j] == 0) {
						solve(i, j);
						cnt++;
					}
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println((max==0)?1:max);
	}
	private static void solve(int row, int col) {
		visit[row][col] = 1;
		for(int i = 0; i < 4; i++) {
			int nr = row + dx[i];
			int nc = col + dy[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(mapCopy[nr][nc] == 1 && visit[nr][nc] == 0)
				solve(nr, nc);
		}
	}
	
}
