import java.util.*;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int index = map.get(calling);

            if (index > 0) { // 첫 번째 인덱스가 아니어야 스왑 가능
                // 현재 calling의 이전 플레이어를 찾음
                String prevPlayer = players[index - 1];

                // players 배열에서 두 플레이어의 위치를 스왑
                players[index - 1] = calling;
                players[index] = prevPlayer;

                // map에서 두 플레이어의 인덱스를 업데이트
                map.put(calling, index - 1);
                map.put(prevPlayer, index);
            }

        }

        // map을 values 값에 따라 정렬
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        // 정렬된 key들을 배열로 변환하여 반환
        String[] result = new String[players.length];
        for (int i = 0; i < entryList.size(); i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }
}