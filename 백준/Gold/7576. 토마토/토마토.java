import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] graph;
    static int M, N;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int bfs() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();
    
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
    
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[current.x][current.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    
        int days = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) return -1;
                days = Math.max(days, graph[i][j]);
            }
        }
    
        return days - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        System.out.println(bfs());
        br.close();
    }
}