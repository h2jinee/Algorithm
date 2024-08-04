import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(sc.readLine());
        int n2 = Integer.parseInt(sc.readLine());
        int n3 = Integer.parseInt(sc.readLine());

        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);
        String s3 = String.valueOf(n3);

        System.out.println(n1 + n2 - n3);
        System.out.println(Integer.parseInt(s1 + s2) - Integer.parseInt(s3));
    }
}