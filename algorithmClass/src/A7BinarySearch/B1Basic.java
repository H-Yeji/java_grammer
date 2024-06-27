package A7BinarySearch;

import java.util.Arrays;

public class B1Basic {

    public static void main(String[] args) {

        // 이분탐색은 사전에 (오름차순) 정렬이 되어있어야 가능한 알고리즘
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        Arrays.sort(arr); // 항상 정렬
        int target = 17;

        int cnt = 0; int index = -1;
        int start = 0; int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
            cnt++;
        }
        if (index != -1) {
            System.out.println("index : " + index);
            System.out.println("count : " + cnt);
        } else {
            System.out.println("없음");
        }

    }
}
