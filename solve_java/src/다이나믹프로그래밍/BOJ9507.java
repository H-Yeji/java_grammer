package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ9507 {
    // 실버4 Generations of Tribbles
    static List<Long> list = new ArrayList<>(); // type 주의 ! 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // list에 값 넣기
        list.add(1L);
        list.add(1L);
        list.add(2L);
        list.add(4L);
        for (int i = 4; i <= 67; i++) {
            list.add(list.get(i - 1) + list.get(i - 2) + list.get(i - 3) + list.get(i - 4));
        }

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(list.get(n));
        }
        sc.close();
    }
}
