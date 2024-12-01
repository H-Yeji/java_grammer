package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14170 {
    // 실버3 - Counting Haybales
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n
        int q = Integer.parseInt(st.nextToken()); // q

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int start = lowerBound(arr, a);
            int end = upperBound(arr, b);

            System.out.println(end - start);
        }
    }

    public static int lowerBound(List<Integer> arr, int a) {
        int index = Collections.binarySearch(arr, a);
//        System.out.println("lowerbound 인덱스: " + index);

        if (index < 0) {
            return -index-1;
        }
        return index;
    }

    public static int upperBound(List<Integer> arr, int b) {
        int index = Collections.binarySearch(arr, b+1);
//        System.out.println("upperbound 인덱스: " + index);
        if (index < 0) {
            return -index-1;
        }
        return index;
    }
}
