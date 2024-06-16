package 조합_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ6603 {

    // 로또
    static void permu(List<List<Integer>> result, List<Integer> s, List<Integer> tmp, int count, int start) {

        // 종료 로직
        if (tmp.size() == count) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < s.size(); i++) {
            tmp.add(s.get(i));
            permu(result, s, tmp, count, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            // 0이 아닐 시
            List<Integer> s = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                s.add(Integer.parseInt(st.nextToken()));
            }

            // 로또 조합
            List<List<Integer>> result = new ArrayList<>();
            permu(result, s, new ArrayList<>(), 6, 0); // 6개의 조합
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                List<Integer> tmp = result.get(i);
                for (int j = 0; j < tmp.size(); j++) {
                    sb.append(tmp.get(j));
                    sb.append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}
