package A7BinarySearch;

import java.util.Arrays;

public class B2Basic2 {

    public static void main(String[] args) {

        // target을 찾되, target이 없으면 -> target보다 큰 값 중 첫번째 값 찾기
        int[] arr = {1, 3, 4, 5, 7, 8, 9};
        int target = 6; // 6이 없으므로 7(의 index)이 나와야함

        int cnt = 0; int index = -1;
        int start = 0; int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= target) {
                index = mid; // ⭐ 클 경우에도 index 저장
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            cnt++;
        }
        System.out.println(index);


        // Arrays.binarySearch 사용해서 가까운 값 찾기
        int[] arr2 = {10, 20, 30};
        System.out.println(Arrays.binarySearch(arr2, 35)); // -4
        System.out.println(Math.abs(Arrays.binarySearch(arr2, 35)) - 1); // 3
        System.out.println(Arrays.binarySearch(arr2, 9)); // -1
        System.out.println(Math.abs(Arrays.binarySearch(arr2, 9)) - 1); // 0
        System.out.println(Arrays.binarySearch(arr2, 25)); // -3
        System.out.println(Math.abs(Arrays.binarySearch(arr2, 25)) - 1); // 2

        // Arrays.binarySearch사용해서 위의 예제(arr) 풀어보기
        int index2 = Arrays.binarySearch(arr, target);
        System.out.println(index2); // -5
        if (index2 < 0) {
            System.out.println(Math.abs(index2) - 1); // 규칙 ⭐ 절댓값 - 1
        } else {
            System.out.println(index2);
        }

    }
}
