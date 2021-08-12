package com.woorim.problems;

import java.util.Arrays;
import java.util.Scanner;

//일곱 난쟁이의 모자에 쓰여 있는 숫자의 합이 100이 되도록 적어 놓았다.
//일곱 난쟁이를 찾는 프로그램을 작성하시오. 
//(아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 찾으시오)


// 비트마스킹을 이용한 풀이 

public class BOJ3040_백설공주와일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 9;
		int R = 7;
		int[] dwarf = new int[N];
		int[] p = new int[N];
		for(int i = 0; i < N; i++) {
			dwarf[i] = sc.nextInt();
		}
	
		// 뒤쪽부터 R 개 만큼 0이 아닌 값을 채운다
		int cnt = 0;
		while(++cnt<=R) p[N-cnt] = 1;
		// p = {0, 0, 1, 1, 1, 1, 1, 1, 1}
		
		do {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(p[i] == 1) {
					sum += dwarf[i];
				}
			}
			if(sum == 100) {
				for(int i = 0; i < 9; i++) {
					if(p[i] == 1) {
						System.out.println(dwarf[i]);
					}
				}
			}
		}while(comb(p));
	}
	
	private static boolean comb(int[] numbers) {
		int N = 9;
		int i = N - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) --i;
		if(i == 0) return false;	
		
		int j = N - 1;
		while(numbers[i-1] >= numbers[j]) --j;
		swap(numbers, i-1, j);
		
		int k = N-1;
		while(i < k) {
			swap(numbers, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
