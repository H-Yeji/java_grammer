package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5575 {

    // 타임 카드
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] work = new int[st.countTokens()];

            for (int j = 0; j < work.length; j++) {
                work[j] = Integer.parseInt(st.nextToken());
            }

            int inTime = ((work[0] * 3600) + (work[1] * 60) + work[2]);
            int outTime = ((work[3] * 3600) + (work[4] * 60) + work[5]);
            int workTime = outTime - inTime;

            System.out.printf("%d %d %d\n", (workTime / 3600), (workTime % 3600) / 60, workTime % 60);
        }
    }
}


