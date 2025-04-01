package implement;

import java.util.*;

public class BOJ1235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> str = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            str.add(s);
        }
        // 탐색
        int cnt = 0;
        for (int i = str.get(0).length() - 1; i >= 0; i--) {
            Set<String> set = new HashSet<>();

            for (int j = 0; j < n; j++) {
//                System.out.println(str.get(j).substring(i));
                set.add(str.get(j).substring(i));
            }
            cnt++;
//            System.out.printf("setsize : %d", set.size());
//            System.out.println();
            if (set.size() == n) break;
        }
        System.out.println(cnt);
        sc.close();
    }
}
