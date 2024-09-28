import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int max = 1000 + 10;
    static int[][] graph;
    static boolean[][] visited;
    static int rows, cols; // 클래스 멤버로 rows와 cols 선언
    static int sum = 0;
    static ArrayList<Integer> answer = new ArrayList<>();

    static int dirX[] = { 0, 0, -1, 1 };
    static int dirY[] = { -1, 1, 0, 0 };

    // 상하좌우로 가려면 (0,-1),(0,1),(-1,0),(1,0)로 가야함

    static void dfs(int y, int x) {
        visited[y][x] = true;
        sum += graph[y][x];
        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if (newY >= 0 && newY < rows && newX >= 0 && newX < cols && graph[newY][newX] != 0 && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public ArrayList<Integer> solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();

        graph = new int[rows][cols];
        visited = new boolean[rows][cols];

        // 2. graph 연결
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (!String.valueOf(maps[i].charAt(j)).equals("X")) {
                    graph[i][j] = Integer.parseInt(String.valueOf(maps[i].charAt(j)));
                }
            }
        }

        // 3. dfs 실행
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    answer.add(sum);
                    sum = 0;
                }
            }
        }

        // 4. 출력
        if (answer.size() == 0) {
            answer.add(-1);
        } else {
            Collections.sort(answer);
        }

        return answer;
    }
}