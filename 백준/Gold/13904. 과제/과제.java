import java.io.*;
import java.util.*;

class Assignment implements Comparable<Assignment> {
    int d; // 마감일
    int w; // 점수

    public Assignment(int d, int w) {
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Assignment other) {
        return Integer.compare(other.w, this.w); // 점수를 기준으로 내림차순 정렬
    }

    @Override
    public String toString() {
        return "[" + d + "," + w + "]";  // 출력 형식
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Assignment> assignments = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            assignments.add(new Assignment(d, w));
        }

        // 마감일 기준으로 내림차순 정렬
        assignments.sort(Comparator.comparingInt(a -> -a.d));

        // 우선순위 큐: 점수를 기준으로 내림차순 정렬
        PriorityQueue<Assignment> pq = new PriorityQueue<>((a, b) -> b.w - a.w);


        int maxDay = assignments.get(0).d;
        int sum = 0;
        int idx = 0;

        for (int day = maxDay; day > 0; day--) {
            // 현재 날짜에 할 수 있는 모든 과제를 우선순위 큐에 추가
            while (idx < N && assignments.get(idx).d >= day) {
                pq.add(assignments.get(idx));
                idx++;
            }

            // 가장 높은 점수를 얻을 수 있는 과제를 선택
            if (!pq.isEmpty()) {
                sum += pq.poll().w;
            }
        }

        System.out.println(sum);
        br.close();
    }
}