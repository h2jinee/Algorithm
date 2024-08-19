import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (isValid(s)) {
                answer++;
            }
            // 문자열 s를 왼쪽으로 한 칸 회전
            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
