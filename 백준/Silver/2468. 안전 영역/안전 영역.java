import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static void dfs(int y, int x, int height) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dirY[i];
            int nx = x + dirX[i];

            if (!visited[ny][nx] && graph[ny][nx] > height) {
                dfs(ny, nx, height);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // x, y
        graph = new int[N + 2][N + 2];
        int maxHeight = 0;

        // 1. graph 정보 반영
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        int maxSafeAreas = 1; // 아무 지역도 물에 잠기지 않을 때의 안전 영역 수는 1

        // 2. 비가 오면 잠기는 지점 설정
        for (int height = 1; height <= maxHeight; height++) {
            visited = new boolean[N + 2][N + 2];
            int safeAreas = 0;

            for (int i = 1; i <= N; i++) { // y
                for (int j = 1; j <= N; j++) { // x
                    if (!visited[i][j] && graph[i][j] > height) {
                        dfs(i, j, height);
                        safeAreas++;
                    }
                }
            }

            maxSafeAreas = Math.max(maxSafeAreas, safeAreas);
        }


        // 3. 출력
        bw.write(String.valueOf(maxSafeAreas));
        bw.newLine();

        bw.close();
        br.close();
    }
}