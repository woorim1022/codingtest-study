package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1208_Flatten {
	static int N, min = 0, max = 99, box[] = new int[100];
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
			System.out.println("#" + t + " " + solve());
			
			
		}

	}
	private static int solve() {
		Arrays.sort(box);
		for(int i = 0; i < N; i++) {
			int v = diff();
			if(v < 2) {
				return v;
			}
			
			box[min]++;
			box[max]--;
			changeMin();
			changeMax();
		}
		return diff();
	}
	
	private static void changeMax() {
		if(box[max] < box[max-1]) max--;
		else max = 99;
	}
	
	private static void changeMin() {
		if(box[min] > box[min+1]) min++;
		else min = 0;
	}
	private static int diff() {
		return box[max] - box[min];
	}

}
