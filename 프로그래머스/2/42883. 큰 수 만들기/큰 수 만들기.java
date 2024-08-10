public class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;  // 최종 결과 문자열의 길이

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            // 스택에 있는 숫자가 현재 숫자보다 작으면 제거하고, k만큼 제거가 가능할 때까지 반복
            while (k > 0 && answer.length() > 0 && answer.charAt(answer.length() - 1) < current) {
                answer.deleteCharAt(answer.length() - 1);
                k--;
            }

            // 스택에 현재 숫자를 추가
            answer.append(current);
        }

        // 최종 결과는 필요한 길이만큼만 잘라서 반환
        return answer.substring(0, len).toString();
    }
}