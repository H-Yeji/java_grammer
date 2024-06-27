package A6투포인터;

public class T2슬라이딩윈도우 {

    public static void main(String[] args) {

        // 정수 배열 nums와 정수 k가 주어졌을 때,
        // 길이가 k인 연속된 부분 배열의 최대합 구하기
        int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        int start = 0; int end = start + (k - 1);
        int sum = 0; int max = 0;
        // 처음 4개 더하기
        for (int i = 0; i < k; i++) {
            sum += nums[i]; // 0 ~ 3번까지 4개 합구해서 초기화
        }
        max = Math.max(sum, max); // max 초기화
        // 나머지 구하기
        while (end < nums.length - 1) {
            sum += nums[++end];
            sum -= nums[start++];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
