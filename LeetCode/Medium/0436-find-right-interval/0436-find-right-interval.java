import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        int[][] starts = new int[n][2];

        // 시작 지점과 인덱스를 저장
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        // 시작 지점을 기준으로 정렬
        Arrays.sort(starts, (a, b) -> a[0] - b[0]);

        // 각 인터벌의 끝 지점에 대해 이진 탐색으로 적절한 시작 지점을 찾음
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int left = 0, right = n - 1;
            int index = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (starts[mid][0] >= end) {
                    index = starts[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = index;
        }

        return result;
    }
}
