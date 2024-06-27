package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9536 {

    // 여우는 어떻게 울지?
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();

            String str = br.readLine();
            String[] sounds = str.split(" ");

            list.addAll(Arrays.asList(sounds)); // 배열 sounds를 list형태로 넣기
            //System.out.println(list);

            while (true) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) break;

                st = new StringTokenizer(input);
                String animal = st.nextToken();
                String goes = st.nextToken();
                String sound = st.nextToken();

                list.removeIf(s->s.equals(sound));
            }
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s).append(" ");
            }
            System.out.println(sb);
        }
    }
}
