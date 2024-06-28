package solve_java;

import java.util.*;

// 메모리초과
/*public class BOJ6443 {

    // 애너그램
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String word = sc.next();

            List<Character> input = new ArrayList<>();
            List<List<Character>> answer = new ArrayList<>();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                input.add(c);
            }
            permutation(answer, new ArrayList<>(), input, new boolean[input.size()]);

            answer.sort((a, b) -> {
                for (int j = 0; j < a.size(); j++) {
                    int cmp = a.get(j).compareTo(b.get(j));
                    if (cmp != 0) return cmp;
                }
                return 0;
            });
            Set<List<Character>> set_answer = new HashSet<>(answer);

            List<String> str = new ArrayList<>();
            for (List<Character> list : set_answer) {
                StringBuilder sb = new StringBuilder();
                for (Character ch : list) {
                    sb.append(ch);
                }
                str.add(sb.toString());
            }

           // Collections.sort(str);
            for (String s : str) {
                System.out.println(s);
            }
        }
    }

    static void permutation(List<List<Character>> answer, List<Character> tmp, List<Character> input, boolean[] visited) {

        if (tmp.size() == input.size()) {
            answer.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            if (visited[i]) continue;
            // if : visited[i] == false
            visited[i] = true;
            tmp.add(input.get(i)); // a b c
            permutation(answer, tmp, input, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}*/

// gpt가 풀어준 코드
public class BOJ6443 {

    // 애너그램
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String word = sc.next();

            List<Character> input = new ArrayList<>();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                input.add(c);

            }
            Collections.sort(input);

            Set<String> answer = new TreeSet<>();
            permutation(answer, new StringBuilder(), input, new boolean[input.size()]);

            for (String s : answer) {
                System.out.println(s);
            }
        }
    }

    static void permutation(Set<String> answer, StringBuilder tmp, List<Character> input, boolean[] visited) {
        if (tmp.length() == input.size()) {
            answer.add(tmp.toString());
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            if (visited[i]) continue;

            // ⭐⭐  set에 넣을 때 중복을 애초에 삭제하기 때문에 -> 메모리 초과가 안남
            if (i > 0 && input.get(i) == input.get(i - 1) && !visited[i - 1]) continue;

            visited[i] = true;
            tmp.append(input.get(i));
            permutation(answer, tmp, input, visited);
            tmp.deleteCharAt(tmp.length() - 1);
            visited[i] = false;
        }
    }
}
