package com.woorim.problems;
/*
 * 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 
 * 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return */
public class PR43165_타겟넘버 {
		static int numsize;
		static int answer = 0;
	    public static void main(String[] args) {
			solution(new int[]{1, 1, 1, 1, 1}, 3);
		}
	    
	    public static int solution(int[] numbers, int target) {
	        numsize = numbers.length;  
	        dfs(0, target, numbers, 0);
	        System.out.println(answer);
	        return answer;
	    }
	    
	    public static void dfs(int idx, int target, int[] numbers, int sum){
	        if(idx == numsize){
	            if(sum == target)
	                answer++;
	            return;
	        }
	        dfs(idx+1, target, numbers, sum+numbers[idx]);
	        dfs(idx+1, target, numbers, sum-numbers[idx]);
	    }
	}
