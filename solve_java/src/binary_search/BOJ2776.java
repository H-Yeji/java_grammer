package binary_search;

import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2776 {

    // 실버4 암기왕
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 수첩1 입력
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            List<Integer> book1 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                book1.add(Integer.parseInt(st.nextToken()));
            }
            // 수첩1 정렬
            Collections.sort(book1);

            // 수첩2 입력
            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int target = Integer.parseInt(st.nextToken());

                // 입력 받을 때마다 타겟 존재여부 확인하기
                int low = 0;
                int high = n - 1; // 4
                boolean flag = false;

                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (book1.get(mid) > target) {
                        high = mid - 1;
                    } else if (book1.get(mid) < target) {
                        low = mid + 1;
                    } else {
                        flag = true; // 해당 숫자가 존재하면 true
                        break;
                    }
                }
                if (flag) System.out.println(1);
                else System.out.println(0);

            }
        }
    }
}
