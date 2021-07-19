package com.woorim.problems;

import java.util.Scanner;

public class SW2072_홀수만더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T;i++) {
			int sum = 0;
			for(int j = 0; j < 10;j++) {
				int num = sc.nextInt();
				if (num % 2 == 1)
					sum += num;
			}
			System.out.println("#"+i+" "+sum);
		}
	}
}
