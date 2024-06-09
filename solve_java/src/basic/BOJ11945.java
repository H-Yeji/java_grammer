package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11945 {

    // 뜨거운 붕어빵
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String arr = br.readLine(); // 한 줄 씩 입력받기
            char[] ch = arr.toCharArray(); // 뒤집기 위해 배열로 변경
            char[] tmp = new char[m];
            for (int j = ch.length - 1, t = 0; j >= 0; j--, t++) { // 뒤집기
                tmp[t] = ch[j];
            }
            String str = new String(tmp); // join 활용을 위해 String으로 변환
            System.out.println(String.join("", str));
        }
    }
}
