import java.util.*;

class Solution {
    public int solution(String s) {
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < alphabet.length; i++) {
            s = s.replaceAll(alphabet[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}