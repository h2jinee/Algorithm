import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : keymap) {
            // keymap을 순찰하며 인덱스가 더 높은 것을 map에 저장
            for (int i = 0; i < key.length(); i++) {
                String currentKey = String.valueOf(key.charAt(i));
                int currentIndex = i + 1;  // 1-based index

                // 현재 map에 저장된 값과 비교하여 더 작은 값을 저장
                if (map.containsKey(currentKey)) {
                    map.compute(currentKey, (k, existingValue) -> Math.min(existingValue, currentIndex));
                } else {
                    map.put(currentKey, currentIndex);
                }
            }
        }

        for (String target : targets) {
            int count = 0;
            boolean isValid = true;

            for (int i = 0; i < target.length(); i++) {
                String currentKey = String.valueOf(target.charAt(i));

                if (map.containsKey(currentKey)) {
                    count += map.get(currentKey);
                } else {
                    count = -1;
                    isValid = false;
                    break; // target의 나머지 부분은 볼 필요가 없음
                }
            }

            if (!isValid) {
                answer.add(-1);
            } else {
                answer.add(count);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
