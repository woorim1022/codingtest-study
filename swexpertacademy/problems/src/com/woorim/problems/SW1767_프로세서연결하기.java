package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
// 0: 빈 셀, 1: core
//최대한 많은 Core에 전원을 연결하였을 경우, 전선 길이의 합을 구하고자 한다.
//단, 여러 방법이 있을 경우, 전선 길이의 합이 최소가 되는 값을 구하라.

public class SW1767_프로세서연결하기 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, maxCoreCnt, totalCoreCnt; 
	static int[][] maxinos;
	static int ans;
	static ArrayList<int[]> list; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			maxinos = new int[N][N];
			
			
			list = new ArrayList<int[]>(); 
			// 입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maxinos[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1 || maxinos[i][j] == 0)
						continue;
					list.add(new int[] { i, j });
				}
			}
			totalCoreCnt = list.size();
			solve(0, 0, 0);	
			System.out.println("#" + t + " " + ans);
		}

	}
	static private void solve(int index, int coreCnt, int wireLen) {
		if (coreCnt  + totalCoreCnt - index < maxCoreCnt) return;
		
		if (index == totalCoreCnt) {
			if (maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				ans = wireLen;
			} else if (maxCoreCnt == coreCnt) { 
				ans = Math.min(ans, wireLen);
			}
			return;
		}

		int[] pos = list.get(index);
		int x = pos[0];
		int y = pos[1];
		for (int d = 0; d < 4; d++) {
			if (possible(x, y, d)) {  
				solve(index + 1, coreCnt + 1, wireLen + setStatus(x, y, d, 2));
				setStatus(x, y, d, 0); 
			}
		}
		solve(index + 1, coreCnt, wireLen);
	}

	private static boolean possible(int x, int y, int dir) {
		int nx = x, ny = y;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) return true;
			if (maxinos[nx][ny] >= 1) return false; 
		}
	}

	private static int setStatus(int x, int y, int dir, int status) {
		int cnt = 0;
		int nx = x, ny = y;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) return cnt;
			
			maxinos[nx][ny] = status;
			cnt++;
		}
	}

}
