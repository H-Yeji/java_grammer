package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2785 {
    // 실버1 체인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        // list 정렬
        Collections.sort(list);

        int sum = list.get(0);
        int usedChain = 1; int index = 0; int result = 0;
        while (true) {
            if (list.size() - usedChain - 1 <= 0) {
                result = usedChain;
                break;
            }
            if (sum < list.size() - usedChain - 1) { // 해당 index의 체인으로 다 엮을 수 없는 경우
                index++;
                sum += list.get(index);
                usedChain++; // index++해서 다음 체인까지 사용 탐색
            } else if (sum == list.size() - usedChain - 1) { // 같을 때 = 충분함
                result = sum;
                break;
            } else { // sum이 클 때 = 이미 다 엮고도 남음 => +1해줘서 남은 체인까지 마지막으로 엮기
                result = list.size() - usedChain; // list.size() - usedChain - 1에다 +1
                break;
            }
        }
        System.out.println(result);
    }
}
