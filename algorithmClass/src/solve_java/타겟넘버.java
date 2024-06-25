package solve_java;


public class 타겟넘버 {

    static int cnt = 0;
    public static void dfs(int[] numbers, int sum, int start, int target) {

        if (start >= numbers.length) {
            if (sum == target) cnt++;
            return;
        }
        dfs(numbers, sum + numbers[start], start + 1, target);
        dfs(numbers, sum - numbers[start], start + 1, target);
    }

    public static int solution(int[] numbers, int target) {

        int sum = 0;
        dfs(numbers, sum, 0, target);

        return cnt;
    }

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        /*int[] numbers = {4, 1, 2, 1};
        int target = 4;*/
        System.out.println(solution(numbers, target));
    }
}
