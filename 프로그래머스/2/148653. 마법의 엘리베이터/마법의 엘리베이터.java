class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int currentDigit = storey % 10;
            int nextDigit = (storey / 10) % 10;

            if (currentDigit > 5 || (currentDigit == 5 && nextDigit >= 5)) {
                answer += 10 - currentDigit;
                storey += 10;  // carry over to the next digit
            } else {
                answer += currentDigit;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
