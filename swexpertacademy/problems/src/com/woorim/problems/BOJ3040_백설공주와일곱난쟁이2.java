package com.woorim.problems;

import java.util.Arrays;
import java.util.Scanner;

// 배열을 이용한 풀이

public class BOJ3040_백설공주와일곱난쟁이2 {
	static int N=9,R=7; 
	static int[] dwarf;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dwarf = new int[N];
		for(int i = 0; i < N; i++) {
			dwarf[i] = sc.nextInt();
		}
		numbers = new int[R];
	
		combination(0,0);
	}
	
	private static void combination(int cnt,int start) {
		if(cnt == R) {
			int sum = 0;
			for(int i = 0; i < cnt; i++) {
				sum += numbers[i];
			}
			if(sum == 100) {
				for(int i = 0; i < cnt; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		// start 위치의 수부터 가능한 수 모두 고려
		for (int i = start; i < N; i++) { // i : 인덱스
			numbers[cnt] = dwarf[i];
			// 다음 자리순열 뽑으로 gogo
			combination(cnt+1,i+1);
		}
		
	}
}
