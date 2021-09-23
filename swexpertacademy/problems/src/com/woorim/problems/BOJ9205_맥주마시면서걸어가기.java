package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ9205_맥주마시면서걸어가기 {
	static class Pos {
	    int x;
	    int y;
	    Pos(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	}

	static Queue<Pos> q;
	static Pos[] pos;
	static int[] check;
	static boolean success;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            q = new LinkedList<Pos>();
            pos = new Pos[N + 2];
            check = new int[N + 2];
            success = false;
            String[] str;
            
            for (int i = 0; i < N + 2; i++) {
                str = br.readLine().split(" ");
                pos[i] = new Pos(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }
            
            solve(N);
            
            if(success) System.out.println("happy");
            else System.out.println("sad"); 
        }
    }
	private static void solve(int N) {
		Pos start = pos[0];
		Pos end = pos[N + 1];  
		q.add(start);    
		
		while (!q.isEmpty()) {
			Pos current = q.poll();
		    if(current.equals(end)){
		        success = true;
		        break;
		    }
		    for (int i = 1; i < N + 2; i++) {
		        if (check[i] == 0 && Math.abs(current.x - pos[i].x) + Math.abs(current.y - pos[i].y) <= 1000) {
		            q.add(pos[i]);
		            check[i] = 1;  
		        }
		    }
		}
		
	}
}
 
