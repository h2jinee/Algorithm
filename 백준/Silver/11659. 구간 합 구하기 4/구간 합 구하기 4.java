import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 배열의 크기와 쿼리의 수를 읽음
        String[] firstLine = sc.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int numberOfQueries = Integer.parseInt(firstLine[1]);

        // 숫자 배열을 읽음
        int[] list = Arrays.stream(sc.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 부분 합 배열 생성
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + list[i - 1];
        }

        // 결과를 저장할 리스트
        List<Integer> results = new ArrayList<>();

        // 각 쿼리를 처리
        for (int i = 0; i < numberOfQueries; i++) {
            // 각 쿼리 라인을 읽고 인덱스를 파싱
            String[] query = sc.readLine().split(" ");
            int first = Integer.parseInt(query[0]);
            int second = Integer.parseInt(query[1]);

            // 부분 합 배열을 사용하여 구간 합 계산
            int sum = prefixSum[second] - prefixSum[first - 1];

            // 결과를 리스트에 저장
            results.add(sum);
        }

        // 모든 결과를 한 번에 출력
        for (int result : results) {
            System.out.println(result);
        }
    }
}