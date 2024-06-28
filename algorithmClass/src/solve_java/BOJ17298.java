package solve_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {

    // 오큰수
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        // stack에 마지막 값 넣기
        stack.push(new int[]{arr[n - 1], n - 1}); // 마지막 값과 그 인덱스
        result[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int[] peekNum = stack.peek();
            if (arr[i] < peekNum[0] && i < peekNum[1]) { // 숫자가 크고 인덱스도 뒤면
                result[i] = peekNum[0];
                stack.push(new int[]{arr[i], i});
            } else {
                while(!stack.isEmpty()) {
                    stack.pop(); // arr[i]보다 작은 값이 스택 가장 위에 있으면 pop

                    if (!stack.isEmpty()) { // pop 한 후의 stack이 비어있지 않으면
                        int[] peekNum2 = stack.peek();
                        if (arr[i] < peekNum2[0]) {
                            result[i] = peekNum2[0];
                            break;
                        }
                    }
                    result[i] = -1;
                }
                stack.push(new int[]{arr[i], i});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
