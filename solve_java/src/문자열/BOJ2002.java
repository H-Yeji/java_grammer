package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class BOJ2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> in = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            in.put(br.readLine(), i);
        }

        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            String carType = br.readLine();
            out[i] = in.get(carType);
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (out[i] > out[j]) {
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
