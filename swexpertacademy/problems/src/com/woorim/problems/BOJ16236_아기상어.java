package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16236_아기상어 {
	static int N;	// 맵의 크기
	static int[][] map;
	static int[] shark, fish; // 상어정보, 먹을 물고기 정보
	static int moveCnt;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			
			System.out.print("#" + t + " " + ans);
		}

	}

}
