package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW9229_한빈이와SpotMart {
	public static int max;
	public static int N, M;
	public static int[] snack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i]= Integer.parseInt(st.nextToken());;
			}
		
			solve(0, 0, 0);
			System.out.println("#"+t+" "+max);
		}
	}
	
	public static void solve(int cnt, int start, int total) {
		if(cnt == 2) {
			if(total <= M) {
				max = Math.max(max, total);;
			}
			return;
		}
		for(int i = start; i < N; i++) {
			solve(cnt + 1, i+1, total + snack[i]);
		}
	}

}
