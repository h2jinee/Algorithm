import java.io.*;
import java.util.StringTokenizer;

class Main {
    final static int MAX = 50 + 10;
    static boolean map[][];
    static int T, N, M, K;

    static int dirY[] = {-1, 1, 0, 0};
    static int dirX[] = {0, 0, -1, 1};

    static void dfs(int y, int x) {
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

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];

            // 1. map 정보 반영
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y + 1][x + 1] = true;

            }

            // 2. dfs 수행
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            // 3. 출력
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
