package 에라토스테네스의_체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1990 {

    // 소수인 팰린드롬 -> 소수찾기
    static ArrayList<Integer> results_prime = new ArrayList<>();
    static ArrayList<Integer> results_palindrome = new ArrayList<>();

    public static void prime(int a, int b) {

        boolean[] isPrime = new boolean[b + 1];

        for (int i = 2; i <= b; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (isPrime[i]) { // 소수면
                for (int j = i * i; j <= b; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = a; i <= b; i++) {
            if (isPrime[i])
                results_prime.add(i);
        }
    }

    public static void palindrome() {

        String word;
        for (Integer result:results_prime) {
            int flag = 0;
            // result를 문자열로 변환
            word = String.valueOf(result);
            for (int i = 0, j = word.length() - 1; i < (int)(word.length() / 2); i++, j--) {
                if (word.charAt(i) != word.charAt(j)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                results_palindrome.add(result);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        prime(a, b); // 소수찾기
        palindrome();

        for (Integer result:results_palindrome) {
            System.out.println(result);
        }
        System.out.println(-1);

    }
}
