package com.woorim.problems;

import java.util.Scanner;

public class SW2071_평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int sum = 0;
			for(int j = 0; j < 10;j++) {
				sum += sc.nextInt();
			}
			System.out.println("#"+ (i+1) +" " + (int)Math.round(sum/10.0));
		}
	}
}
