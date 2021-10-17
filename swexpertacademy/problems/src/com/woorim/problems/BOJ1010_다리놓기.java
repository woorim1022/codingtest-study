package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1010_다리놓기 {
	static int N, M;
	static int[] choose;
	static int ans;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			System.out.println();
			choose = new int[N];
			// 메모이제이션 
			// 
			dp = new int[31][31];
			

			System.out.println(combination(M, N));
		}
	}
	
	static private int combination(int m, int n) {
		if(m == n || n == 0) {	// 종료조건
			return 1;
		}
		if(dp[m][n] != 0) { // 계산이 되어있는 상태 
			return dp[m][n];	// 따로 계산을 하지 않고 현재 저장되어 있는 값을 리턴하고 끝낸다
		}
		// m = 5, n = 2
		dp[m][n] = combination(m-1, n) + combination(m-1, n-1);
		// 5C2 = 4C2 + 4C1
		return dp[m][n];
	}

}
