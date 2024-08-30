import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int hour = Integer.parseInt(s.split(" ")[0]);
        int minute = Integer.parseInt(s.split(" ")[1]);

        if (minute >= 45) {
            System.out.println(hour + " " + (minute - 45));
        } else if (hour == 0){
            System.out.println(23 + " " + (minute + 60 - 45));
        } else {
            System.out.println(hour - 1 + " " + (minute + 60 - 45));
        }
    }
}