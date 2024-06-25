package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20920 {

    // 영단어 암기는 괴로워
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

        // 길이순 -> 사전순으로 정렬
        Comparator<String> com = (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            } else {
                return a.compareTo(b);
            }
        };
        Arrays.sort(arr, com);

        // 위에서 얻은 배열을 map에 <word, count>형태로 넣기
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (b.getValue().equals(a.getValue())) { // 개수가 같으면
                return a.getKey().compareTo(b.getKey()); // 사전순 오름차순
            }
            return b.getValue() - a.getValue(); // 개수가 같지 않으면 값으로 내림차순
        });

        for (Map.Entry<String, Integer> l : list) {
            System.out.println(l.getKey());
        }
    }
}

/**
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 * import java.util.*;
 *
 * public class BOJ20920 {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         StringTokenizer st = new StringTokenizer(br.readLine());
 *         int n = Integer.parseInt(st.nextToken());
 *         int m = Integer.parseInt(st.nextToken());
 *
 *         Map<String, Integer> wordCount = new HashMap<>();
 *
 *         for (int i = 0; i < n; i++) {
 *             String word = br.readLine();
 *             if (word.length() >= m) {
 *                 wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
 *             }
 *         }
 *
 *         List<String> sortedWords = new ArrayList<>(wordCount.keySet());
 *         sortedWords.sort((a, b) -> {
 *             if (wordCount.get(a).equals(wordCount.get(b))) {
 *                 if (a.length() != b.length()) {
 *                     return Integer.compare(b.length(), a.length());  // 길이가 긴 순
 *                 }
 *                 return a.compareTo(b);  // 사전순
 *             }
 *             return Integer.compare(wordCount.get(b), wordCount.get(a));  // 빈도수 높은 순
 *         });
 *
 *         sortedWords.forEach(System.out::println);
 *     }
 * }
 */
