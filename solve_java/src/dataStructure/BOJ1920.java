package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1920 {

    public static int binarySearch(List<Integer> listA, int target, int start, int end) {

        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (listA.get(mid) == target)
            return mid;

        if (listA.get(mid) > target) {
           return binarySearch(listA, target, start, mid-1);
        } else {
            return binarySearch(listA, target, mid + 1, end);
        }
    }

    // BOJ1920 수 찾기 - binary search 활용
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> listA = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }
        //listA.sort(Comparator.naturalOrder());
        Collections.sort(listA);

        // 함수 호출
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int result = binarySearch(listA, target, 0, n-1);

            if (result == -1) System.out.println(0);
            else System.out.println(1);
        }
    }
}
