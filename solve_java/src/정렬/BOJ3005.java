package 정렬;

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ3005 {
    // 실버2 크로스워드 퍼즐 쳐다보기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] puzzle = new char[r][c];
        for (int i = 0; i < r; i++) { // for문 하나로 입력받는 방법 !
            String line = br.readLine();
            puzzle[i] = line.toCharArray();
        }

        Set<String> treeSet = new TreeSet<>(); // 객체를 기준으로 정렬
        // 가로로 된 단어 저장
        for (char[] line : puzzle) {
            StringBuilder sb = new StringBuilder();
            for (char word : line) {
                if (word != '#') {
                    sb.append(word);
                } else {
                    if (sb.length() >= 2) treeSet.add(String.valueOf(sb));
                    sb = new StringBuilder(); // 새로 생성
                }
            }
            if (sb.length() >= 2) treeSet.add(String.valueOf(sb));
        }
        // 세로로 된 단어 저장
        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                if (puzzle[j][i] != '#') {
                    sb.append(puzzle[j][i]);
                } else {
                    if (sb.length() >= 2) treeSet.add(String.valueOf(sb));
                    sb = new StringBuilder();
                }
            }
            if (sb.length() >= 2) treeSet.add(String.valueOf(sb));
        }

        String[] arr = treeSet.toArray(new String[0]);
        System.out.println(arr[0]);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
