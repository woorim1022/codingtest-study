package com.woorim.problems;

import java.util.Arrays;
import java.util.Scanner;

// 신맛은 사용한 재료의 신맛의 곱이고, 
//쓴맛은 합이다.
//재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리의 차이

public class BOJ2961_도영이가만든맛있는음식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] ing = new int[N][2];
		for(int i = 0; i < N; i++) {
			ing[i][0] = sc.nextInt();
			ing[i][1] = sc.nextInt();
		}
		
		// 부분집합
		int flag = 1;
		int min = 1000000000;
		while(flag < Math.pow(2, N)) {
			int sour = 1;
		    int bitter = 0;
			for (int i = 0; i < N; i++) {
				if((flag & 1<<i) != 0) {
					// 선택
					sour *= ing[i][0];
					bitter += ing[i][1];
				}
			}
			if(Math.abs(sour-bitter) < min) {
				min = Math.abs(sour-bitter);
			}
			flag++;
		}
		System.out.println(min);
		
		
		
	}
	
	

}
