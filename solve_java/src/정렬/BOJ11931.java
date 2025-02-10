package 정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ11931 {
    // 실버5 수 정렬하기4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
             list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
