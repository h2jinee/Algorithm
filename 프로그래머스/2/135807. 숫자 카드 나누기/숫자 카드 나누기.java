import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // array 배열의 최대공약수를 구하고
        int arrayAGcd = findArrayGcd(arrayA);
        int arrayBGcd = findArrayGcd(arrayB);
        
        int[] array = arrayAGcd > arrayBGcd ? arrayB : arrayA;
        int answer = arrayAGcd > arrayBGcd ? arrayAGcd : arrayBGcd;
        
        for (int i = 0; i < array.length; i++) {
            // gcd에서 다른 array[i]의 값이 1개라도 나누어 떨어지면 조건이 만족을 못한다.
            // 5 % 10 = 5
            // 5 % 17 = 5
            if ((array[i] % answer) == 0) {
                answer = 0;
                break;
            }
        }

        
        // 그 둘을 비교해서 큰 수 반환
        return answer;
    }
    
    private int gcd(int a, int b) {
        // GCD는 음수에 대해 정의되지 않으므로 절댓값을 사용합니다.
        // GCD(a, b) = GCD(|a|, |b|)
        a = Math.abs(a);
        b = Math.abs(b);

        // 유클리드 호제법
        // b가 0이 될 때까지 (a % b) 연산을 반복합니다.
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        // b가 0이 되면, a가 최대공약수입니다.
        // (참고: GCD(n, 0) = n)
        return a;
    }
    
    public int findArrayGcd(int[] numbers) {
        // 1. 배열의 첫 번째 요소를 초기 결과값(result)으로 설정합니다.
        int result = numbers[0];

        // 2. 배열의 두 번째 요소부터 마지막까지 순회합니다.
        for (int i = 1; i < numbers.length; i++) {
            // 3. 현재까지의 결과(result)와 현재 요소(numbers[i])의 GCD를 계산하여
            //    result를 업데이트합니다.
            result = gcd(result, numbers[i]);

            // (선택적 최적화)
            // GCD 결과가 1이 되면, 더 이상 계산할 필요가 없습니다.
            // (1과 다른 수의 GCD는 항상 1)
            if (result == 1) {
                return 1;
            }
        }

        // 4. 모든 순회가 끝나면 최종 결과(result)를 반환합니다.
        return result;
    }
}