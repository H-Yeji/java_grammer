package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

    // 공유기 설치 - 골드4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집 개수
        int c = Integer.parseInt(st.nextToken()); // 공유기 수

        long[] house = new long[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house); // 정렬

        long start = 1; long end = house[n - 1] - house[0];
        long result = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            //System.out.println("mid : "+ mid);

            int cnt = 1; // 첫번째 집 공유기 설치하고 시작
            long pre = house[0]; // 첫번째 집 공유기
            for (int i = 1; i < n; i++) {
                long diff = house[i] - pre;
                if (diff >= mid){
                    cnt++;
                    pre = house[i];
                }
            }
            //System.out.println("cnt : " + cnt);
            if (cnt >= c) {
                result = mid;
                //System.out.println(result);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
