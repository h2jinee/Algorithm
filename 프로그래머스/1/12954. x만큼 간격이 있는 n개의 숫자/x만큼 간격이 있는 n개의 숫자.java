class Solution {
    public long[] solution(int x, int n) {
        long x2 = (long)x;
        long n2 = (long)n;
        long[] answer = new long[n];
        
        for (int i = 0; i < n2; i++) {
            answer[i] = x2 * (i + 1);
        }
        
        return answer;
    }
}