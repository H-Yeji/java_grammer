package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1Basic {

    public static void main(String[] args) {

        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6};
        int target = 10;


        // (1) nums 배열에서 target이 될 수 있는 두 수의 조합 찾기
        //Arrays.sort(nums); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        //System.out.println(Arrays.toString(nums));

        // for문
        /*List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    list.add(new int[]{nums[i], nums[j]}); // 배열 형태로 인덱스 넣기
                }
            }
        }
        System.out.println("for문");
        for (int[] l : list) {
            System.out.println(Arrays.toString(l));
        }

        // 투포인터
        List<int[]> list2 = new ArrayList<>();
        int i = 0; int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else { // 같으면
                list2.add(new int[]{nums[i], nums[j]});
                i++; j--; // 중복 숫자가 없으면 둘다 ㅇㅣ동 (아니면 하나만 이동)
            }
        }
        System.out.println("while문 - 투포인터 ");
        for (int[] l : list2) {
            System.out.println(Arrays.toString(l));
        }*/

        // (2) 구간의 합 - 구간의 합이 target이 되는 배열의 index의 처음과 끝 리스트에 담기
        System.out.println(Arrays.toString(nums));
        List<int[]> list3 = new ArrayList<>();
        // [7, 8, 9, 2, 4, 5, 1, 3, 6]]
        int start = 0; int end = 0;
        int sum = nums[0];
        while (start <= end) {
            if (sum == target) {
                list3.add(new int[]{start, end});
                sum -= nums[start];
                start++;
            } else if (sum < target && end < nums.length - 1) {
                end++;
                sum += nums[end];
            } else {
                sum -= nums[start];
                start++;
            }
        }
        for (int[] l : list3) {
            System.out.println(Arrays.toString(l));
        }
    }
}
