import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int[][] graph;
    static boolean[][] visited;
    static int sum, M, N;
    static ArrayList<Integer> answer = new ArrayList<>();

    static int dirX[] = { 0, 0, -1, 1 };
    static int dirY[] = { -1, 1, 0, 0 };

    static void dfs(int y, int x) {
        visited[y][x] = true;
        sum += graph[y][x];
        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if (graph[newY][newX] != 0 && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public ArrayList<Integer> solution(String[] maps) {
        M = maps.length;
        N = maps[0].length();

        graph = new int[M + 2][N + 2];
        visited = new boolean[M + 2][N + 2];

        // 2. graph 연결
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char c = maps[i].charAt(j);
                if (c != 'X') {
                    graph[i + 1][j + 1] = Character.getNumericValue(c);
                }
            }
        }

        // 3. dfs 실행
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    answer.add(sum);
                    sum = 0;
                }
            }
        }

        // 4. 출력
        if (answer.isEmpty()) {
            answer.add(-1);
        } else {
            Collections.sort(answer);
        }

        return answer;
    }
}