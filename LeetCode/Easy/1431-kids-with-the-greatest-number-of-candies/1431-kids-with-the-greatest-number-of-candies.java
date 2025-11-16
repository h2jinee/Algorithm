class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> answer = new ArrayList<>();
        for (int candy : candies) {
            if ((candy + extraCandies) >= max) {
                answer.add(true);
                continue;
            }
            answer.add(false);
        }
        return answer;
    }
}