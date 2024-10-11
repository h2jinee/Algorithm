import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N, M;

    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};
    static int answer;
    static int max = 0;
    static int count = 0;

    static void dfs(int y, int x) {
        count++;
        visited[y][x] = false;
        max = Math.max(max, count);
        for (int i = 0; i < 4; i++) {
            int ny = y + dirY[i];
            int nx = x + dirX[i];

            if (visited[ny][nx] && graph[ny][nx] != 0) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // y
        N = Integer.parseInt(st.nextToken()); // x

        graph = new int[M + 2][N + 2];
        visited = new boolean[M + 2][N + 2];

        // 1. graph 정보 반영
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = true;
            }
        }

        // 2. dfs 수행
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] != 0 && visited[i][j]) {
                    answer++;
                    count = 0;
                    dfs(i, j);
                }
            }
        }

        // 3. 출력
        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.write(String.valueOf(max));

        bw.close();
        br.close();
    }
}