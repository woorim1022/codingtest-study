package com.woorim.problems;

import java.util.Scanner;

public class BOJ1992_쿼드트리 {
	public static int[][] map;	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];	
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		solve(0, 0, N);
		System.out.println(sb);
	}
	public static void solve(int x, int y, int N) {
		if(compress(x, y, N)) {
			sb.append(map[x][y]);
			return;
		}
		int newN = N / 2;	
		sb.append('(');	
		solve(x, y, newN);					
		solve(x, y + newN, newN);				
		solve(x + newN, y, newN);				
		solve(x + newN, y + newN, newN);	
		sb.append(')');	
	}
	// 압축 가능 여부 체크
	public static boolean compress(int x, int y, int N) {
		int value = map[x][y];
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(value != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
 
}