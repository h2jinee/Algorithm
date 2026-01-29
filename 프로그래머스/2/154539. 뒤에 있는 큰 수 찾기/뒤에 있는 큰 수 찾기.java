import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        // 1. 모든 결과값을 -1로 초기화 (뒷 큰수를 못 찾으면 그대로 -1)
        Arrays.fill(answer, -1);
        
        // 2. 인덱스를 담을 스택 (대기실) 생성
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // 3. 대기실에 사람이 있고, 현재 숫자(numbers[i])가 대기실의 숫자보다 크다면?
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                // 대기실에 있던 숫자의 뒷 큰수를 현재 숫자로 확정하고 퇴장시킨다.
                answer[stack.pop()] = numbers[i];
            }
            
            // 4. 현재 숫자의 인덱스를 대기실에 넣는다.
            stack.push(i);
        }
        
        return answer;
    }
}