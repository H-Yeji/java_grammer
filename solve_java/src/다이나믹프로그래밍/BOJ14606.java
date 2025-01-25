package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ14606 {
    // 실버5 피자 (small)
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // idx=0, idx=1에 0넣기
        list.add(0);
        list.add(0);
        for (int i = 2; i <= n; i++) {
            list.add((i - 1) + list.get(i - 1));
        }
        System.out.println(list.get(n));
        sc.close();
    }
}
