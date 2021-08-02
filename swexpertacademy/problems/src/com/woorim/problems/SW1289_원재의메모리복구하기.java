package com.woorim.problems;

import java.util.Arrays;
import java.util.Scanner;

public class SW1289_원재의메모리복구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++) {
			char[] tc = sc.next().toCharArray();
			// 1 ~ 앞 bit와 다르면 +1
//			System.out.println(Arrays.toString(tc));
			int ans = 0;
			for(int j = 0 ;j < tc.length; j++) {
				if(j == 0 && tc[j] == '1') {
					ans++;
				}
				if(j != 0 && tc[j] == '1' && tc[j-1] == '0') {
					ans++;
				}
				if(j != 0 && tc[j] == '0' && tc[j-1] == '1') {
					ans++;
				}
			}
			System.out.println("#" + i + " " + ans);
		}

	}

}
