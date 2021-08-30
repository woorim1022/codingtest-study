package com.woorim.problems;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309_일곱난쟁이 {
	static int[] dwarf = new int[9];
	static int[] family = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}
		solve(0, 0);

	}
	private static void solve(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += family[i];
			}
			if(sum == 100) {
				Arrays.sort(family);
				for(int i : family) {
					System.out.println(i);
				}
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			family[cnt] = dwarf[i];
			solve(cnt+1, i+1);
		}
	}
}
