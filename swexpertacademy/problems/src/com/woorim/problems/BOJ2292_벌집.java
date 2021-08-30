package com.woorim.problems;

import java.util.Scanner;

public class BOJ2292_벌집 {
	static int N;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		solve();
		System.out.println(ans);
	}
	private static void solve() {
		int temp = 0;
		int cnt = 0;
		int minN;
		int maxN = 0;
		while(true) {
			minN = maxN + 1;
			maxN = 6 * temp + 1;
			if (N >= minN && N <= maxN) {
				ans = cnt+1;
				return;
			}
			temp += ++cnt;
		}
	}
}
