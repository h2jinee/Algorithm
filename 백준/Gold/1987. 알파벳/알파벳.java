import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N, M;
    static HashSet<Integer> set = new HashSet<>();
    static int maxPath = 0;

    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static int dfs(int y, int x, int depth) {
        maxPath = Math.max(maxPath, depth);

        visited[y][x] = false;
        set.add(graph[y][x]);
        for (int i = 0; i < 4; i++) {
            int ny = y + dirY[i];
            int nx = x + dirX[i];

            if (visited[ny][nx] && !set.contains(graph[ny][nx])) {
                dfs(ny, nx, depth + 1);
            }
        }
        set.remove(graph[y][x]);
        visited[y][x] = true;
        return maxPath;
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
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder str = new StringBuilder(st.nextToken());

            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                graph[i + 1][j + 1] = Character.getNumericValue(c);
                visited[i + 1][j + 1] = true;
            }
        }

        // 2. dfs 수행
        dfs(1, 1, 1);

        // 3. 출력
        bw.write(String.valueOf(maxPath));
        bw.newLine();

        bw.close();
        br.close();
    }
}