import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static int[] dirY = { 1, -1, 0, 0 };
    static int[] dirX = { 0, 0, 1, -1 };
    static int T, N, M, K;
    static boolean answer;

    public static void dfs(int y, int x) {
        if (y == N) {
            answer = true;
            return;
        }

        map[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dirY[i];
            int nx = x + dirX[i];
            if (map[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 2][M + 2];

        // 1. map 정보 반영
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) == '0';
            }
        }

        // 2. dfs 수행
        for(int j = 1; j <= M; j++) {
            if(map[1][j]) {
                dfs(1, j);
            }
        }

        // 3. 출력
        if(answer) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.close();
        br.close();
    }
}
