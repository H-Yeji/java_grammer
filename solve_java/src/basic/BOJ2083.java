package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2083 {

    //럭비 클럽
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            // 종료조건
            if (name.equals("#") && age == 0 && height == 0) break;

            if (age > 17 || height >= 80) {
                System.out.printf("%s %s\n", name, "Senior");
            } else {
                System.out.printf("%s %s\n", name, "Junior");
            }
        }
    }
}
