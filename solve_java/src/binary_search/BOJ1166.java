package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1166 {

    // 선물 - 실버3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 상자 개수
        int l = Integer.parseInt(st.nextToken()); // 직육면체의 length
        int w = Integer.parseInt(st.nextToken()); // 직육면체의 width
        int h = Integer.parseInt(st.nextToken()); // 직육면체의 height

        double min = Math.min(Math.min(l, w), h);

        double start = 0; double end = min;
        double result = 0;
        for (int i = 0; i < 5000; i++) {
            double mid = (start + end) / 2.0; // mid : 한 변의 길이
            long cnt = (long) (l / mid) * (long) (w / mid) * (long) (h / mid);

            if (cnt >= n) {
                result = mid;
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(result);
    }
}
