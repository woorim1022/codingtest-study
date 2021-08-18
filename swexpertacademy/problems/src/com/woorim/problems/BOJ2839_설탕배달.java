package com.woorim.problems;
import java.util.Arrays;
//봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
//정확하게 N킬로그램을 배달
//봉지 몇 개를 가져가면 되는지 그 수를 구하라
import java.util.Scanner;

public class BOJ2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int[] memo = new int[M+1];
		for(int i = 0; i < memo.length; i++) {
			if(i % 3 == 0) {
				memo[i] = i / 3;
			} else {
				memo[i] = 987654321;
			}
		}
		for(int i = 5; i < memo.length; i++) {
			if(memo[i] > memo[i-5] + 1) {
				memo[i] = memo[i-5] + 1;
			}
		}
//		System.out.println(Arrays.toString(memo));
		System.out.println(memo[M] == 987654321 ? -1: memo[M]);
		sc.close();
	}
}




//public class BOJ2839_설탕배달 {
//	static int goal, ans = -1;
//	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		goal = sc.nextInt();
//		sc.close();
//		if(goal == 4 || goal == 7) {
//			System.out.println(ans);
//		}
//		solve(0,0);
//	}
//	static void solve(int weight, int cnt) {
//		if(weight > goal) return;
//		if(weight == goal) {
//			System.out.println(cnt);
//			System.exit(0);
//		}
//		solve(weight+5, cnt+1);
//		solve(weight+3, cnt+1);
//	}
//	
//}




//public class BOJ2839_설탕배달 {
//	static int N;
//	static int ans = 0;
//	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		while(true) {
//			if(N % 5 == 0) {
//				ans += N/5;
//				break;
//			}
//			if(N < 3) {
//				ans = -1;
//				break;
//			}
//			N -= 3;
//			ans++;
//			
//		}
//		System.out.println(ans);
//	}
//	
//}
