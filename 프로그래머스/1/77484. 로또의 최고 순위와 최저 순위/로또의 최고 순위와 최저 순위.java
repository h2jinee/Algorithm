import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;
        
        Set<Integer> winningNumbers = new HashSet<>();

        for (int winNumber : win_nums) {
            winningNumbers.add(winNumber);
        }
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            } else if (winningNumbers.contains(lotto)) {
                matchCount++;
            }
        }
        
        int bestRank = calculateRank(matchCount + zeroCount);
        int worstRank = calculateRank(matchCount);
        
        return new int[] {bestRank, worstRank};
    }
    
    private int calculateRank(int count) {
        if (count <= 1) {
            return 6;
        }

        return 7 - count;
    }
}