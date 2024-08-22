import java.util.Scanner;

public class Main {

    static int n;
    static int[] stones;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt(); // 돌의 개수
        stones = new int[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            stones[i] = sc.nextInt();
        }
        
        int start = sc.nextInt(); // 시작점 (1부터 시작)
        
        int result = dfs(start);
        System.out.println(result);
        
        sc.close();
    }
    
    static int dfs(int current) {
        visited[current] = true;
        int count = 1; // 현재 위치도 방문했으므로 1을 셉니다.
        
        int left = current - stones[current];
        int right = current + stones[current];
        
        if (left >= 1 && !visited[left]) {
            count += dfs(left);
        }
        
        if (right <= n && !visited[right]) {
            count += dfs(right);
        }
        
        return count;
    }
}
