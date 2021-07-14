package com.ssafy.startcamp;

import java.util.Scanner;

public class boj2577_숫자의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int[] ans = new int[10];
		int res = A * B * C;
		
		while (res != 0)
	    {
			int temp = res % 10;
			ans[temp] ++;
			res /= 10;
	    }
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
