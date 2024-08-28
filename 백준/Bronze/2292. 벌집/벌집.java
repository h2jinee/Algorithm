
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(sc.readLine());

        int layer = 1; // 층 (1층부터 시작)
        int range = 2; // 첫 번째 층을 넘어서부터 범위는 2부터 시작 (1이 첫 번째 껍질에 속하므로)

        if (s == 1) { // 첫 번째 껍질은 1이므로 바로 출력
            System.out.println(1);
        } else {
            while (range <= s) { // s가 속한 범위를 찾을 때까지 반복
                range = range + (6 * layer); // 다음 껍질의 최대값을 계산
                layer++; // 층 수 증가
            }
            System.out.println(layer); // s가 속한 층 출력
        }
    }
}