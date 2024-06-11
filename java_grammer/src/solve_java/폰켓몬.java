package solve_java;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

    public static int solution(int[] nums) {
        int answer = 0;
        int n = (int)(nums.length/2);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <nums.length; i++) {
            set.add(nums[i]);
        }

        if (set.size() <= n) {
            answer = set.size();
        } else {
            answer = n;
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {3,1,2,3};
        System.out.println(solution(nums));
    }
}
