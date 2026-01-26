class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 다 사용했을 때
        if (index == numbers.length) {
            // sum과 타넷이 같으면 1, 아니면 0 반환
            return sum == target ? 1 : 0;
        }
        
        return dfs(numbers, target, index + 1, sum + numbers[index])
             + dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}