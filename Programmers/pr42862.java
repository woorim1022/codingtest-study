import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] st = new int[n];
        //st배열 1로 초기화
        for(int i = 0; i < st.length; i++){
            st[i] = 1;
        }
        //reserve면 +1, lost면 -1
        for(int i = 0; i < st.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] == i+1)
                    st[i]++;
            }
            for(int j = 0; j < lost.length; j++){
                if(lost[j] == i+1)
                    st[i]--;
            }
        }
        for(int i = 0; i < st.length; i++){
            //st[i] == 0 이면
            if(st[i] == 0){
                if(i > 0 && st[i-1]==2){
                    st[i-1]--;
                    st[i]++;
                }
                else if(i+1 < n && st[i+1]==2){
                    st[i+1]--;
                    st[i]++;
                }
                else continue;
            }
        }
        for(int i = 0; i < st.length; i++){
            if(st[i] != 0)
                answer++;
        }
        
        return answer;
    }
}