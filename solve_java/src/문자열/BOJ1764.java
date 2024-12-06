package 문자열;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ1764 {

    // 실버4 듣보잡 (문자열)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 못듣
        int m = Integer.parseInt(st.nextToken()); // 못본

        // map 선언
        Map<String, Integer> names = new TreeMap<>();
        // n 입력
        for (int i = 0; i < n; i++) {
            names.put(br.readLine(), 1); // key,value
        }
        // m 입력
        for (int i = 0; i < m; i++) {
            String newName = br.readLine();
            names.put(newName, names.getOrDefault(newName, 0) + 1);
        }
//        System.out.println(names); // {baesangwook=2, charlie=1, clinton=1, obama=1, ohhenrie=2}

        int cnt = 0;
        for (int nameCount: names.values()) {
            if (nameCount == 2) cnt++;
        }
        bw.write(String.valueOf(cnt)); // String.valueOf로 int 출력
        bw.newLine();
//        System.out.println(cnt);

        for (String name: names.keySet()) {
            if (names.get(name) == 2) {
                bw.write(name); // string 형태 출력
                bw.newLine();
                //System.out.println(name);
            }
        }
        bw.flush(); // 버퍼 내용 출력
        bw.close();
        br.close();
    }
}
