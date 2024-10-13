import java.io.*;
import java.util.*;

class Main {
    static String[][] graph;
    static boolean[][] visited;
    static int N;
    static int answer = 0;
    static int answer2 = 0;

    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static void dfs(int y, int x, boolean daltonism) {
        visited[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dirY[i];
            int nx = x + dirX[i];
            if (visited[ny][nx]) {
                if (!daltonism) {
                    if (graph[ny][nx].equals(graph[y][x])) {
                        dfs(ny, nx, daltonism);
                    }
                } else {
                    if (graph[y][x].equals("B")) {
                        if (graph[ny][nx].equals("B")) {
                            dfs(ny, nx, daltonism);
                        }
                    } else if (graph[ny][nx].equals("R") || graph[ny][nx].equals("G")) {
                        dfs(ny, nx, daltonism);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // N 입력

        graph = new String[N + 2][N + 2];
        visited = new boolean[N + 2][N + 2];

        // 1. graph 정보 반영
        for (int i = 1; i <= N; i++) {
            String line = br.readLine(); // 띄어쓰기 없이 한 줄을 입력받음
            for (int j = 1; j <= N; j++) {
                graph[i][j] = String.valueOf(line.charAt(j - 1)); // 한 글자씩 접근
                visited[i][j] = true;
            }
        }

        // 2. 적록색약이 아닌 경우 영역 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i][j]) {
                    answer++; // 적록색약이 아닌 경우 영역 증가
                    dfs(i, j, false); // 적록색약이 아닌 경우 DFS
                }
            }
        }

        // visited 배열 초기화
        visited = new boolean[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited[i][j] = true;
            }
        }

        // 3. 적록색약인 경우 영역 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i][j]) {
                    answer2++; // 적록색약인 경우 영역 증가
                    dfs(i, j, true); // 적록색약인 경우 DFS
                }
            }
        }

        // 4. 출력
        bw.write(answer + "\n" + answer2);
        bw.close();
        br.close();
    }
}
