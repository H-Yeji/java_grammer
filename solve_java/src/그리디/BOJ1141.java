package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class BOJ1141 {
    // 실버1 접두사
    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            set.add(word);
        }

        String prev = " ";
        int removeCnt = 0;
        for (String current : set) {
            if (current.startsWith(prev)) {
//                System.out.printf("current: %s \n", current);
//                System.out.printf("지워진것: %s\n", prev);
                removeCnt++;
            }
            prev = current;
        }
        System.out.println(set.size() - removeCnt);
    }
}
