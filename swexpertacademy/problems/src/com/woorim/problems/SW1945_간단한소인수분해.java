package com.woorim.problems;

import java.util.Scanner;

public class SW1945_간단한소인수분해 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T;i++) {
			int N = sc.nextInt();
			double[] num = {2.0,3.0,5.0,7.0,11.0};
			
			System.out.print("#" + (i+1));
			for(int j = 0; j < 5; j++) {
				int ans = 0;
				double res = N / num[j];
				while((res - (int)res) == 0.0) {
					ans++;
					res = (int)(res) / num[j];
				}
				System.out.print(" " +ans);
			}
			System.out.println();
		}
		
	}

}
