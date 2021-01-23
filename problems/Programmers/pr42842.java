class Solution {
    public int[] solution(int brown, int yellow) {
        int temp = brown - 4;
        int a1 = 2;
        int a2 = temp - a1;
        int [] answer = new int[2];
        while(a1 <= a2){
            if(a1/2 * a2/2 == yellow){
                answer[0] = a2/2 + 2;
                answer[1] = a1/2 + 2;
                break;
            }
            a1+=2;
            a2-=2;
        }
        return answer;
    }
}