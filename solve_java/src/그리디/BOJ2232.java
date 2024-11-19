package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2232 {
    // 실버2 - 지뢰 (그리디 & 정렬)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 넣을 list
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
//        System.out.println(Arrays.toString(arr));
        //[1, 2, 5, 4, 3, 3, 6, 6, 2]
        int[] land_mind = new int[n];
        Arrays.fill(land_mind, n); // land_mind를 n으로 전체값 초기화

        // 첫번째 앞에서부터 턴
        for (int i = 0; i < n - 1; i++) {
            // 다음과 비교해서 작으면 -1
            if (arr[i] < arr[i + 1]) {
                land_mind[i] -= 1;
            }
        }
        // 두번째 뒤에서부터 턴
        for (int i = n - 1; i >= 1; i--) {
            // 이전과 비교해서 작으면 -1
            if (arr[i] < arr[i - 1]) {
                land_mind[i] -= 1;
            }
        }
//        System.out.println(Arrays.toString(land_mind));
        // 출력
        for (int i = 0; i < n; i++) {
            if (land_mind[i] == n) {
                System.out.println(i + 1);
            }
        }
    }
}
