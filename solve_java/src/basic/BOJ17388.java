package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17388 {

    // 와글와글 숭고한
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken()); // Soongsil
        int k = Integer.parseInt(st.nextToken()); // Korea
        int h = Integer.parseInt(st.nextToken()); // Hanyang

        if (s + k + h >= 100) {
            System.out.println("OK");
        } else {
            if (s < k && s < h) {
                System.out.println("Soongsil");
            } else if (k < s & k < h) {
                System.out.println("Korea");
            } else if (h < s && h < k) {
                System.out.println("Hanyang");
            }
        }
        br.close();
    }
}
