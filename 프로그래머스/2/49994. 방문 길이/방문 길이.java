import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<List<Integer>> visitedPaths = new HashSet<>();
        int answer = 0;

        int x = 0;
        int y = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);

            int nextX = x;
            int nextY = y;

            if (command == 'U') {
                nextY++;
            } else if (command == 'D') {
                nextY--;
            } else if (command == 'R') {
                nextX++;
            } else if (command == 'L') {
                nextX--;
            }
            
            if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }

            List<Integer> path = List.of(x, y, nextX, nextY);
            List<Integer> reversePath = List.of(nextX, nextY, x, y);

            if (!visitedPaths.contains(path)) {
                visitedPaths.add(path);
                visitedPaths.add(reversePath);
                answer++;
            }

            x = nextX;
            y = nextY;
        }

        return answer;
    }
}