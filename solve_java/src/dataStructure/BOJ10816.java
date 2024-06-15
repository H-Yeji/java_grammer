package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        Map<Integer, Integer> map = new HashMap<>();
        // HashMap 활용
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(st.nextToken());
            map.put(data, map.getOrDefault(data, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 반복된 sout는 시간초과 발생 -> StringBuilder 활용
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(target, 0)).append(' ');
            //System.out.printf("%d ", map.getOrDefault(target, 0));
        }
        System.out.println(sb.toString().trim());
    }
}
