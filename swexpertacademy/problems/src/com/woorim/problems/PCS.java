package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PCS {
	static int[] numbers;
	static boolean[] visitP;
	static boolean[] visitC;
	static boolean[] visitS;
	static int[] per;
	static int[] com;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		visitP = new boolean[N];
		visitC = new boolean[N];
		visitS = new boolean[N];
		per = new int[M];
		com = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println("순열");
		permutation(0);
		
		System.out.println("조합");
		combination(0, 0);
		
		System.out.println("부분집합");
		subset(0);

	}
	// 순열코드
	private static void permutation(int cnt) {
//		if(cnt == M) {
//			for(int i = 0; i < M; i++) {
//				System.out.print(per[i]);
//			}
//			System.out.println();
//			return;
//		}
//		for(int i = 0; i < N; i++) {
//			if(visitP[i] == true) continue;
//			else {
//				visitP[i] = true;
//				per[cnt] = numbers[i];
//				permutation(cnt+1);
//				visitP[i] = false;
//			}
//		}
	}
	
	// 조합
	private static void combination(int cnt, int start) {
//		if(cnt == M) {
//			for(int i = 0; i < M; i++) {
//				System.out.print(com[i]);
//			}
//			System.out.println();
//			return;
//		}
//		for(int i = start; i < N; i++) {
//			com[cnt] = numbers[i];
//			combination(cnt+1, i+1);
//		}

	}
	
	// 부분집합
	private static void subset(int cnt) {
//		if(cnt == N) {
//			for(int i = 0; i < N; i++) {
//				if(visitS[i] == true) {
//					System.out.print(numbers[i]);
//				}
//				else {
//					System.out.print("X");					
//				}
//			}
//			System.out.println();
//			return;
//		}
//		visitS[cnt] = true;
//		subset(cnt+1);		
//		visitS[cnt] = false;
//		subset(cnt+1);
//
	}

}
