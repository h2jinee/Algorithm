class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1;

        // 모든 dp 요소를 1로 초기화 (모든 숫자는 자신만으로 LIS가 될 수 있기 때문에 최소 길이는 1)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // dp 테이블 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 최장 길이 갱신
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
