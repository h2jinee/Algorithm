import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();  // 테스트 케이스의 수

        for (int i = 0; i < t; i++) {
            int h = scanner.nextInt();  // 호텔의 층 수
            int w = scanner.nextInt();  // 각 층의 방 수 (사용되지 않음)
            int n = scanner.nextInt();  // n번째 손님

            int floor = (n % h == 0) ? h : n % h;  // 손님이 배정될 층
            int roomNumber = (n % h == 0) ? (n / h) : (n / h) + 1;  // 해당 층의 방 번호

            System.out.printf("%d%02d%n", floor, roomNumber);
        }

        scanner.close();
    }
}
