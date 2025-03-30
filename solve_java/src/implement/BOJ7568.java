package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ7568 {
    // 실버5 - 덩치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<int[]> xy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
             xy.add(new int[]{x, y});
        }
        int[] rank = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] left = xy.get(i);
                int[] right = xy.get(j);

                if (left[0] < right[0] && left[1] < right[1]) { // left가 둘다 작으면
                    rank[i] += 1;
                } else if (left[0] > right[0] && left[1] > right[1]) { // right가 둘다 작으면
                    rank[j] += 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", rank[i] + 1);
        }
    }
}
