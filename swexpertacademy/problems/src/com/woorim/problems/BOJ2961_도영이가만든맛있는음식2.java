package com.woorim.problems;

import java.util.Scanner;

public class BOJ2961_도영이가만든맛있는음식2 {
	public static boolean[] isSelected;
	public static int[][] ing;
	public static int N;
	public static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		min = Integer.MAX_VALUE;
		ing = new int[N][2];
		for(int i = 0; i < N; i++) {
			ing[i][0] = sc.nextInt();
			ing[i][1] = sc.nextInt();
		}
		isSelected = new boolean[N];
		subset(0);
		System.out.println(min);
	}

	private static void subset(int cnt) {
		if(cnt == N) {
			int sour = 1;
		    int bitter = 0;
		    for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sour *= ing[i][0];
					bitter += ing[i][1];
				}
			}
		    if(sour == 1 && bitter == 0) return;
			min = Math.min(min,Math.abs(sour-bitter));
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}
	
}
