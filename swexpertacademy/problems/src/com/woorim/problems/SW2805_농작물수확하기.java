package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW2805_농작물수확하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int start = N/2, end = N/2;
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = (int)(line.charAt(j)-'0');
				}
			}
//			System.out.println(Arrays.deepToString(map));
			
			
			for(int i = 0; i < N; i++) {
				for(int j = start; j <= end; j++) {
					ans += map[i][j];
				}
				if(i < N/2) {					
					start--;
					end++;
				}
				else {
					start++;
					end--;
				}
			}
			
			
			System.out.println("#" + t + " " + ans);
		}
	}
}