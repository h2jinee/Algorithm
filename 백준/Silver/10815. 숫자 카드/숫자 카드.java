
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 입력 처리
        int n = Integer.parseInt(sc.readLine());
        String[] inputArray = sc.readLine().split(" ");
        
        // HashSet에 첫 번째 배열의 요소 저장
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(inputArray[i]));
        }

        // 두 번째 입력 처리
        int n2 = Integer.parseInt(sc.readLine());
        String[] inputArray2 = sc.readLine().split(" ");
        
        // 결과를 저장할 StringBuilder
        StringBuilder answer = new StringBuilder();
        
        // 두 번째 배열의 각 요소가 첫 번째 배열에 있는지 확인
        for (int i = 0; i < n2; i++) {
            if (set.contains(Integer.parseInt(inputArray2[i]))) {
                answer.append("1 ");
            } else {
                answer.append("0 ");
            }
        }

        // 마지막 공백을 제거하고 결과 출력
        System.out.println(answer.toString().trim());
    }
}