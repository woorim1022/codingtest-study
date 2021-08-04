package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW2001_파리퇴치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(Arrays.deepToString(map));
			
			int kill = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					kill = 0;
					for(int p = i; p < M+i; p++) {
						for(int q = j; q < M+j; q++) {
							if(p >= 0 && p < N && q >= 0 && q < N) {
								kill += map[p][q];
							}
						}
					}
					if(kill >= max) max = kill;
					
				}
			}
			System.out.println("#" + t + " " + max);
		}

	}

}
