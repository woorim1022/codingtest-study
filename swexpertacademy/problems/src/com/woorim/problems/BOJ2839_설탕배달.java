package com.woorim.problems;
//봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
//정확하게 N킬로그램을 배달
//봉지 몇 개를 가져가면 되는지 그 수를 구하라
import java.util.Scanner;

public class BOJ2839_설탕배달 {
	static int N;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		while(true) {
			if(N % 5 == 0) {
				ans += N/5;
				break;
			}
			if(N < 3) {
				ans = -1;
				break;
			}
			N -= 3;
			ans++;

		}
		System.out.println(ans);
	}

}
