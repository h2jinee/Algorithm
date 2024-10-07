import java.io.*;
import java.util.*;

class Num implements Comparable<Num> {
    int X; // 무게
    int Y; // 크기

    public Num(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public int compareTo(Num other) {
        // 먼저 X 값으로 오름차순 정렬
        if (this.X != other.X) {
            return Integer.compare(this.X, other.X);
        }
        // X 값이 같으면 Y 값으로 오름차순 정렬
        return Integer.compare(this.Y, other.Y);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 좌표의 수
        int N = Integer.parseInt(st.nextToken());

        List<Num> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            list.add(new Num(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
        }

        Collections.sort(list);

        for (Num num : list) {
            bw.write(num.X + " " + num.Y + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}