package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10610 {
    // 실버4 30 (배수판정법 활용)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Integer.parseInt(String.valueOf(n.charAt(i)));
        }

        // 3의 배수 => 모든 자리를 더한 합이 3의 배수
        // 10의 배수 => 0으로 끝남
        if (sum % 3 != 0 || !n.contains("0")) { // 둘 중 하나라도 충족 못하면
            System.out.println("-1");
            return; // 종료
        }

        char[] arr = n.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
        br.close();
    }
}
