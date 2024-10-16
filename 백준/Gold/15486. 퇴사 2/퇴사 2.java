import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] table;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // y
        table = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 2];
        
        // 1. DP 배열 초기화
        Arrays.fill(dp, 0);

        // 2. 점화식을 이용한 DP 배열 채우기
        for (int i = N; i > 0; i--) {
            if (i + table[i][0] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[i + table[i][0]] + table[i][1]);
            }
        }

        int answer = dp[1];

        // 3. 출력
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}