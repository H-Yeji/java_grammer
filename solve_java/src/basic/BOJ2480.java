package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2480 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && b == c) { // 모두 같을 때
            System.out.println(10000 + (a * 1000));
        } else if (a != b && b != c && a != c) { // 모두 다를 때
            if (a  > b && a > c) { // a가 제일 커
                System.out.println(a * 100);
            } else if (b > a && b > c) { // b가 제일 커
                System.out.println(b * 100);
            } else { // c가 제일 커
                System.out.println(c * 100);
            }
        } else {
            if (a == b) {
                System.out.println(1000 + (a * 100));
            } else if (a == c) {
                System.out.println(1000 + (a * 100));
            } else {
                System.out.println(1000 + (b * 100));
            }
        }
    }
}
