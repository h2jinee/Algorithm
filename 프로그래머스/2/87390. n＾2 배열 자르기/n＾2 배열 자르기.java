import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            long x = (i + left) % n;
            long y = (i + left) / n;
            
            if (x > y) {
                answer[i] = (int)x + 1;
            } else {
                answer[i] = (int)y + 1;
            }
        }
        
        return answer;
    }
}