package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17266 {
    // 실버4 어두운 굴다리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] location = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            location[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1; // 굴다리 최소 길이
        int high = n; // 굴다리 길이 최대
        int result = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            boolean flag = true;

            int point = 0;
            for (int loc: location){
                // 현재 위치에서 mid만큼 불을 비춘게 이전 위치(point)까지 도달하지 못하면
                // 비추지 못하는 곳이 존재한다는 뜻 = falase
                if (loc - mid <= point) {
                    point = loc + mid; // 0부터 loc+mid까지 비출 수 있음
                } else {
                    flag = false;
                }
            }

            // 마지막부터 point까지도 확인
            if (n - point > 0) flag = false;
            else flag = true;

            if (flag){
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}
