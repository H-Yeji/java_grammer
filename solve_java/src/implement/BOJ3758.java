package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3758 {
    // 실버2 KCPC
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 개수
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken()); // 팀 수
            int problem = Integer.parseInt(st.nextToken()); // 문제 수
            int myTeam = Integer.parseInt(st.nextToken()); // 내 팀
            int m = Integer.parseInt(st.nextToken()); // 반복

            // 2차 배열
            int[][] arr = new int[team][problem];
            int[] submit = new int[m]; // 문제 제출 순서
            int[] totalScore = new int[team];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken()); // 팀id
                int proId = Integer.parseInt(st.nextToken()); // 문제id
                int score = Integer.parseInt(st.nextToken()); // 점수
                submit[j] = teamId; // 제출한 순서 저장

                if (arr[teamId - 1][proId - 1] != 0) { // 이미 점수가 있으면
                    if (score > arr[teamId - 1][proId - 1]) { // 새로 받은 score이 더 크면 그거 저장, 아니면 유지
                        arr[teamId - 1][proId - 1] = score;
                    }
                } else {
                    arr[teamId - 1][proId - 1] = score;
                }
            }
            for (int j = 0; j < team; j++) {
                for (int k = 0; k < problem; k++) {
                    totalScore[j] += arr[j][k];
                }
            }
            int range = 1;
            int myScore = totalScore[myTeam - 1];
            for (int j = 0; j < team; j++) {
                if (j != myTeam - 1) { // 내 팀은 패스
                    if (totalScore[j] > myScore) { // 내 팀 스코어보다 높으면 range++
                        range++;
                    } else if (totalScore[j] == myScore) { // 점수 같으면 제출 비교
                        int your = 0; int mine = 0;
                        for (int k = 0; k < submit.length; k++) {
                            if (submit[k] == j + 1) your++;
                            if (submit[k] == myTeam) mine++;
                        }
//                        System.out.printf("너 팀 제출 횟수 : %d, 내 팀 제출 : %d\n", your, mine);
                        // 내 제출 횟수가 더 많으면 range++ (순위 뒤로 밀림)
                        if (your < mine) range++;
                        // 제출 횟수까지 같으면 => 제출 시기 비교
                        else if (your == mine) {
                            for (int k = submit.length - 1; k >= 0; k--) { // 뒤에서부터 탐색
                                if (submit[k] == j + 1 || submit[k] == myTeam) {
                                    if (submit[k] == j + 1) {
                                        break;
                                    }
                                    else {
                                        range++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(range);
        }
    }
}
