import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();

            answer += a + b;

            // 합친 결과를 다시 우선순위 큐에 추가
            pq.offer(a + b);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
