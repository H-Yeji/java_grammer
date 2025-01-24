package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ9625 {
    // 실버5 BABBA
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        // 초기
        listA.add(1); listB.add(0);

        for (int i = 0; i <= n; i++) {
            int preA = listA.get(i);
            int preB = listB.get(i);

            listA.add(preB); // listA = 이전 B의 개수
            listB.add(preA + preB); // listB = 이전 A의 개수 + 이전 B의 개수
        }
        System.out.printf("%d %d", listA.get(n), listB.get(n));

        br.close();
    }
}
