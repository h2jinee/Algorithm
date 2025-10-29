import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        // 1. 정답 배열을 numbers의 길이로 생성하고, 모두 -1로 초기화
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        // 2. '아직 뒷 큰수를 찾지 못한' 원소의 인덱스를 담을 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 3. numbers 배열을 0번부터 끝까지 순회 (i = 현재 인덱스)
        for (int i = 0; i < numbers.length; i++) {
            
            // 4. 스택이 비어있지 않고, 스택의 top(peek)에 있는 인덱스(j)의 값(numbers[j])이 현재 값(numbers[i])보다 작다면
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                // -> 현재 값(numbers[i])이 스택 top에 있던 원소(j)의 '뒷 큰수'가 됨
                
                // 스택에서 j를 꺼내서(pop)
                int index = stack.pop();
                // answer[j]에 현재 값(numbers[i])을 저장
                answer[index] = numbers[i];
            }

            // 5. 현재 인덱스(i)를 스택에 push
            stack.push(i);
        }

        // 6. 배열 순회가 끝나면 answer를 반환
        return answer;
    }
}