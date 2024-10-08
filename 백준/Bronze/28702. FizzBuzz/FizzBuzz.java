import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[3];
        int num = 0;
        int k;
        int answer = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i] = st.nextToken();
        }

        for (k = 0; k < array.length; k++) {
            if (!array[k].equals("Fizz") && !array[k].equals("Buzz") && !array[k].equals("FizzBuzz")) {
                num = Integer.parseInt(array[k]);
                break;
            }
        }

        if (k == 0) {
           answer = num + 3;
        } else if (k == 1) {
            answer = num + 2;
        } else if (k == 2) {
            answer = num + 1;
        }

        if (answer % 3 == 0 && answer % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (answer % 3 == 0) {
            System.out.println("Fizz");
        } else if (answer % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(answer);
        }

    }
}