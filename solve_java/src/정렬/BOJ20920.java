package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20920 {

    // 영단어 암기는 괴로워 - 정렬
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 단어 입력받아 arr 생성
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            arr[i] = word;
        }
        // 길이가 m개 이상인 단어만 filtering
        arr = Arrays.stream(arr)
                .filter(a->a.length()>=m)
                .toArray(String[]::new);
        // map에 word와 개수 넣기
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (a.getValue() != b.getValue()) { // count가 다르면 -> count 순으로 내림차순
                return b.getValue() - a.getValue();
            } else { // count가 같으면
                if (a.getKey().length() != b.getKey().length()) { // word 길이로 내림차순
                    return b.getKey().length() - a.getKey().length();
                } else { // word의 길이가 같으면
                    return a.getKey().compareTo(b.getKey()); // 사전순으로 정렬
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> l : list) {
            sb.append(l.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
