import java.io.*;
import java.util.*;

class Jewel implements Comparable<Jewel> {
    int M; // 무게
    int V; // 크기

    public Jewel(int M, int V) {
        this.M = M;
        this.V = V;
    }

    @Override
    public int compareTo(Jewel jewel) {
        // 먼저 M 값으로 오름차순 정렬
        if (this.M != jewel.M) {
            return Integer.compare(this.M, jewel.M);
        }
        // M 값이 같으면 V 값으로 내림차순 정렬
        return Integer.compare(jewel.V, this.V);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        int idx = 0;

        // 보석 수
        int N = Integer.parseInt(st.nextToken());
        // 가방 수
        int K = Integer.parseInt(st.nextToken());

        Integer[] C = new Integer[K];
        List<Jewel> jewels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer jewel = new StringTokenizer(br.readLine());
            // 보석 무게
            int M = Integer.parseInt(jewel.nextToken());
            // 보석 크기
            int V = Integer.parseInt(jewel.nextToken());

            jewels.add(new Jewel(M, V));
        }

        for (int i = 0; i < K; i++) {
            StringTokenizer bag = new StringTokenizer(br.readLine());
            // 가방에 담을 수 있는 최대 무게
            C[i] = Integer.parseInt(bag.nextToken());
        }

        Collections.sort(jewels);
        Arrays.sort(C);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < C.length; i++) {
            while (idx < N && jewels.get(idx).M <= C[i]) {
                pq.add(jewels.get(idx).V);
                idx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        bw.write(sum + "");
        bw.close();
        br.close();
    }
}