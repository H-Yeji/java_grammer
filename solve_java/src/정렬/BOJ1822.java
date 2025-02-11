package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ1822 {
    // 실버4 차집합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Long> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            setA.add(Long.parseLong(st.nextToken()));
        }
        Set<Long> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            setB.add(Long.parseLong(st.nextToken()));
        }

        int cnt = 0;
        Set<Long> result = new TreeSet<>();
        for (Long i: setA) {
            if (!setB.contains(i)) {
                cnt++;
                result.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Long i: result) {
            sb.append(i).append(" ");
        }
        // 출력
        if (cnt != 0) {
            System.out.println(cnt);
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
        br.close();
    }
}
