package 정렬;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BOJ1302 {
    // 실버4 베스트셀러
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> books = new TreeMap<>(); //key 기준으로 오름차순
        for (int i = 0; i < n; i++) {
            String title = sc.next();
            books.put(title, books.getOrDefault(title, 0) + 1);
        }

        int max = 0;
        String bestSeller = "";
        for (String book : books.keySet()) {
            if (books.get(book) > max) {
                max = books.get(book);
                bestSeller = book;
            }
        }
        System.out.println(bestSeller);
        sc.close();
    }
}
