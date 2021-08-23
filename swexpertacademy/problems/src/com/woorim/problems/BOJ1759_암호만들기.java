package com.woorim.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 
//최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
//암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열
//abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
//암호로 사용했을 법한 문자의 종류는 C가지
//C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성
public class BOJ1759_암호만들기 {
	static int L, C;
	static char[] words;
	static char[] password;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		String[] strarr = sc.nextLine().split(" ");
		words = new char[C];
		for(int i = 0 ; i < strarr.length; i++) {
			words[i] = strarr[i].charAt(0);
		}
		Arrays.sort(words);
		visited = new boolean[C];
		password = new char[L];
		// 순열
		solve(0, 0);

	}
	private static void solve(int cnt, int start) {
		if(cnt == L) {
			int parent = 0;
			int child = 0;
			for(int i = 0; i < L; i++) {
				if(password[i] == 'a' 
						|| password[i] == 'e' 
						|| password[i] == 'i' 
						|| password[i] == 'o' 
						|| password[i] == 'u') {
					parent++;
				}else {
					child++;
				}
			}
			if(parent >= 1 && child >= 2) {
				for(int i = 0; i < L; i++) {
						System.out.print(password[i]);
				}
				System.out.println();
			}
			return;
		}
		for(int i = start; i < C; i++) {
			if(!visited[i]) {
				visited[i] = true;
				password[cnt] = words[i];
				solve(cnt+1, i+1);
				visited[i] = false;
				
			}
		}
	}
}
