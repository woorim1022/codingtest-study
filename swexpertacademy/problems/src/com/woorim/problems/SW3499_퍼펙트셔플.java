package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW3499_퍼펙트셔플 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] ans = new String[N];
			String[] card = br.readLine().split(" ");
			
			int flag = 0;
			if(N % 2 == 1) flag = 1;
			for(int i = 0; i < N/2; i++) {
				ans[i*2] = card[i];
				ans[i*2+1] = card[N/2+i+flag];
			}
			if(flag == 1) ans[N-1] = card[N/2];
			

			System.out.print("#" + t + " ");
			for(String a : ans)
				System.out.print(a + " ");
			System.out.println();
		}

	}

}
