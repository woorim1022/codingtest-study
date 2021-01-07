class Solution {
    
    boolean[] visit = new boolean[201];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(i, n, computers);
                answer++;
                // System.out.println(computers.length + "----" + computers[i].length);
            }
        }
        return answer;
    }
    
    public void dfs(int i, int n, int[][] computers){
        visit[i] = true;
        
        for(int j = 0; j < n; j++){
            if((!visit[j]) && (computers[i][j]==1)){
                dfs(j, n, computers);
            }
        }
    }
}