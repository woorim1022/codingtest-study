package com.woorim.problems;

import java.util.Scanner;

public class SW1024_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int num = sc.nextInt();
			int[] arr = new int[101];
			int max = 0;
			int score = 0;
			for(int j = 0; j < 1000;j++) {
				score = sc.nextInt();
				arr[score] ++;
			}
			for (int j = 0; j < 101; j++) {
				if(arr[j] >= arr[max]) {
					max = j;
				}
			}
			System.out.println("#"+i+" "+max);
		}
	}
}
