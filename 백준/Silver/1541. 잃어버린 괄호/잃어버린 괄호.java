import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] str = st.nextToken().split("-");

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            if (str[i].contains("+")) {
                String[] numbers = str[i].split("\\+");
                // 각 숫자를 정수로 변환하고 합산
                int sum = 0;
                for (String num : numbers) {
                    sum += Integer.parseInt(num);
                }
                list.add(sum);
            } else {
                list.add(Integer.valueOf(str[i]));
            }
        }

        // 첫 번째 숫자를 초기값으로 설정
        int result = list.get(0);

        // 연산자를 기준으로 숫자를 계산
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }

        // 3. 출력
        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
        br.close();
    }
}