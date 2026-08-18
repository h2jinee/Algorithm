class Solution {

    public long solution(int k, int d) {
        long answer = 0;
        long maxDistanceSquared = (long) d * d;

        for (int x = 0; x <= d; x += k) {
            long remainingSquared = maxDistanceSquared - (long) x * x;
            long maxY = (long) Math.sqrt(remainingSquared);

            answer += maxY / k + 1;
        }

        return answer;
    }
}