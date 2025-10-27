import java.util.*;

class Solution {
    public int[] solution(long n) {
        var list = new LinkedList<Integer>();
        
        while(n != 0) {
            list.push((int)(n % 10));
            n = n / 10;
        }
        
        Collections.reverse(list);
        
        int[] answer = new int[list.size()];
        for(int i = 0; list.size() > i; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}