package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16435 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> fruits = new ArrayList<>();
        while (st.hasMoreTokens()) {
            fruits.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬
        Collections.sort(fruits);

        for (int fruit: fruits) {
            if (b >= fruit) {
                b += 1; // snake 길이 +1
            }
        }
        System.out.println(b);
    }
}
