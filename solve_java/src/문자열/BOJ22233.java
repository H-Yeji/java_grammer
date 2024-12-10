package 문자열;

import java.io.*;
import java.util.*;

public class BOJ22233 {

    // 실버3 가희와 키워드
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 메모장에 입력받기
        Set<String> notes = new HashSet<>(); // set: 중복 없음
        for (int i = 0; i < n; i++) {
            notes.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String newInput = br.readLine();
            String[] writes = newInput.split(",");
            for (String write : writes) {
                if (notes.contains(write)) {
                    notes.remove(write);
                }
            }
            bw.write(notes.size() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
