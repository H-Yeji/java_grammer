package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10655 {
    // 실버3 마라톤1
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            // 총 거리 구하기
            sum += distance(i, i + 1);
        }

        // 모든 지점 돌면서 탐색
        int result = sum;
        for (int i = 1; i < n - 1; i++) {
            int tmp = sum - (distance(i, i - 1) + distance(i , i + 1)) +
                    distance(i - 1, i + 1);

            result = Math.min(tmp, result);
        }
        System.out.println(result);
    }

    private static int distance(int now, int next) {
        // 두 지점의 거리 반환
        return Math.abs(list.get(now).x - list.get(next).x)
                + Math.abs(list.get(now).y - list.get(next).y);
    }
}
