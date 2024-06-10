package solve_java;

import java.util.Arrays;

public class n의_배수_고르기 {

    // 배열로 풀기
    public static int[] solution(int n, int[] numlist) {
        int[] tmp = new int[10000];
        int cnt = 0;
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                tmp[cnt] = numlist[i];
                cnt++;
            }
        }
        int[] answer = Arrays.copyOfRange(tmp, 0, cnt);

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};

        System.out.println(Arrays.toString(solution(n, numlist)));
    }
}

/**
 * 리스트로 풀기
 *
 * import java.util.*;
 * class Solution {
 *
 *     public int[] solution(int n, int[] numlist) {
 *         int[] answer;
 *         List<Integer> list = new ArrayList();
 *         for(int i=0;i<numlist.length;i++) { // 리스트로 선언해서 add로 값넣기
 *             if((numlist[i] % n )== 0) {
 *                 list.add(numlist[i]);
 *             }
 *         }
 *         answer = new int[list.size()]; // 해당 크기만큼 배열 할당
 *         for(int i=0;i<list.size();i++) { // 값 넣기
 *             answer[i] = list.get(i);
 *         }
 *
 *         System.out.println(list);
 *         return answer;
 *     }
 * }
 */
