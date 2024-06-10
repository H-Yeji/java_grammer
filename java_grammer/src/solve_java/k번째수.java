package solve_java;
import java.util.Arrays;

public class k번째수 {

    public static int[] solution(int[] arr, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];

            int[] tmp = new int[end - start + 1];
            for (int j = start - 1, k = 0; j < end; j++, k++) {
                tmp[k] = arr[j];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[num - 1];
        }
        return answer;
    }
    public static void main(String[] args) {

        //int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[] arr = {1, 5, 2, 60, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = solution(arr, commands);
        System.out.println(Arrays.toString(answer));
    }
}
