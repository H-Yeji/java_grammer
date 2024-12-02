package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2792 {

    // 실버1 보석상자 (이진탐색) ⭐⭐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        List<Integer> jewels = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            jewels.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(jewels); // 정렬
//        System.out.println(jewels.toString());

        int low = 1;
        int high = jewels.get(m-1); // max값
        while (low < high) {
            int mid = (low + high) / 2;
            long student = 0;

            for (int jewel: jewels) {
                if (jewel % mid == 0) {
                    student += (jewel / mid);
                } else {
                    student += (jewel / mid) + 1; // ⭐⭐ 나누어 떨어지지 않으면 +1로 학생수 추가
                }
            }
            // 총 명수와 비교해서 자리 이동
            if (student > n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }
}
