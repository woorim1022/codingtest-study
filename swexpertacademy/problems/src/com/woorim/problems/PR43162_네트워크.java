package com.woorim.problems;

public class PR43162_네트워크 {

	 static boolean[] visit = new boolean[201];
	 public static void main(String[] args) {
		solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
	}
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(i, n, computers);
                answer++;
                // System.out.println(computers.length + "----" + computers[i].length);
            }
        }
        System.out.println(answer);
        return answer;
    }
    
    public static void dfs(int i, int n, int[][] computers){
        visit[i] = true;
        
        for(int j = 0; j < n; j++){
            if((!visit[j]) && (computers[i][j]==1)){
                dfs(j, n, computers);
            }
        }
    }

}
