package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2563_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		String[] line;
		int x, y;
		for(int i = 0; i < N;i++) {
			line = br.readLine().split(" ");
			x = Integer.parseInt(line[0]);
			y = Integer.parseInt(line[1]);
//			System.out.println(x);
//			System.out.println(y);
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					arr[j][k] = 1;
				}
			}
		}
//		for(int j = 0; j < 26; j++) {
//			System.out.println(Arrays.toString(arr[j]));
//		}
		int ans = 0;
		for(int j = 0; j < 100; j++) {
			for(int k = 0; k < 100; k++) {
				if(arr[j][k] == 1) ans++;
			}
		}
		
		System.out.println(ans);
	}

}
