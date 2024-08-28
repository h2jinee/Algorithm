import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str = sc.readLine();
        String s = sc.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));  // 스택에 문자 추가

            // 스택의 마지막 부분이 폭발 문자열과 일치하는지 확인
            if (stack.size() >= s.length()) {
                boolean match = true;
                for (int j = 0; j < s.length(); j++) {
                    if (stack.get(stack.size() - s.length() + j) != s.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // 일치하면 스택에서 폭발 문자열 길이만큼 pop
                if (match) {
                    for (int j = 0; j < s.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        // 스택에 남아 있는 문자들을 합쳐서 출력
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        if (result.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(result.toString());
        }
    }
}
