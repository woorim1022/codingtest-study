class Solution {
    
    int numsize;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        numsize = numbers.length;  
        dfs(0, target, numbers, 0);
        return answer;
    }
    
    public void dfs(int idx, int target, int[] numbers, int sum){
        if(idx == numsize){
            if(sum == target)
                answer++;
            return;
        }
        dfs(idx+1, target, numbers, sum+numbers[idx]);
        dfs(idx+1, target, numbers, sum-numbers[idx]);
    }
}