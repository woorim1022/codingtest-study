package com.woorim.problems;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기_teacher {
    public static void main(String[] args) throws FileNotFoundException {
    	// 1 0 0 0 1 1 0 1 
    	System.setIn(new FileInputStream("src/day0803/com/ssafy/offline/input1244.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int num = sc.nextInt();
        int loc = 0;
        
        // 남학생 1, 여학생 2
        for (int i = 0; i < num; i++) {
            switch (sc.nextInt()) {
                case 1:
                    // 남학생
                    loc = sc.nextInt();
                    for (int j = loc; j <= N; j += loc) {
                        arr[j] = (arr[j] + 1) % 2;
                    }
                    break;
                case 2:
                    // 여학생
                    loc = sc.nextInt();
                    int l = loc, r = loc;
                    while (l >= 1 && r <= N) {
                    	if (arr[l] != arr[r]) break;
                    	
                    	arr[r] = arr[l] = (arr[l] + 1) % 2;
                        l--;
                        r++;
                    }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }

        sc.close();
    }
}