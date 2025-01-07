package 정렬;

import java.io.*;
import java.util.*;

public class BOJ20291 {
    // 실버3 파일 정리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> files = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String file = br.readLine();
            String[] splitFile = file.split("\\."); // ⭐
            files.put(splitFile[1], files.getOrDefault(splitFile[1], 0) + 1);
        }

        List<String> fileTypes = new ArrayList<>(files.keySet());
        Collections.sort(fileTypes); // 오름차순 정렬

        for (String type : fileTypes) {
            bw.write(type + " " + files.get(type) + "\n");
//            System.out.printf("%s %d\n", type, files.get(type));
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
