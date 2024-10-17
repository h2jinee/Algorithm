import java.io.*;
import java.util.*;

class Studyroom implements Comparable<Studyroom> {
    int S;  // 시작 시간
    int T;  // 종료 시간

    public Studyroom(int S, int T) {
        this.S = S;
        this.T = T;
    }

    @Override
    public int compareTo(Studyroom other) {
        if (this.S == other.S) {
            return Integer.compare(this.T, other.T);
        }
        return Integer.compare(this.S, other.S);  // 시작 시간 기준으로 정렬
    }

    @Override
    public String toString() {
        return "[" + S + "," + T + "]";  // 출력 형식
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Studyroom> pq = new PriorityQueue<>();

        // Studyroom 객체 생성 및 PQ에 추가
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            pq.add(new Studyroom(S, T));  // 우선순위 큐에 추가
        }

        // 현재 진행 중인 강의들의 종료 시간을 저장할 우선순위 큐
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        // 첫 번째 강의의 종료 시간 추가
        endTimes.add(pq.poll().T);

        // 나머지 강의들 처리
        while (!pq.isEmpty()) {
            Studyroom current = pq.poll();

            // 현재 강의의 시작 시간이 가장 빨리 끝나는 강의실의 종료 시간보다 크거나 같으면
            // 해당 강의실 재사용 가능
            if (current.S >= endTimes.peek()) {
                endTimes.poll(); // 기존 종료 시간 제거
            }

            // 현재 강의의 종료 시간 추가
            endTimes.add(current.T);
        }

        // 필요한 강의실의 개수는 endTimes 큐의 크기와 같음
        System.out.println(endTimes.size());

        br.close();
    }
}
