import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        ArrayList<Integer> citationList = new ArrayList<>();

        for (int i = 0; i < citations.length; i++) {
            citationList.add(citations[i]);
        }

        citationList.sort(Collections.reverseOrder());

        for (int i = 0; i < citationList.size(); i++) {
            if (citationList.get(i) >= i + 1) {
                answer++;
            }
        }
        return answer;
    }
}