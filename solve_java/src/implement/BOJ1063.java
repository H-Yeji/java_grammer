package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1063 {
    // 실버3 킹
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String dol = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        // 체스판
        String[][] chess = new String[8][8];
        boolean[][] dolLocation = new boolean[8][8];
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int num = 8;
        int kingI = 0, kingJ = 0, dolI = 0, dolJ = 0;
        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(alphabet[j]).append(num);
                chess[i][j] = String.valueOf(sb);

                if (chess[i][j].equals(king)) {
                    kingI = i; kingJ = j;
                } else if (chess[i][j].equals(dol)) {
                    dolLocation[i][j] = true;
                    dolI = i; dolJ = j;
                }
            }
            num--;
        }

        for (int i = 0; i < n; i++) {
            Map<String, int[]> directions = new LinkedHashMap<>();
            directions.put("B", new int[]{kingJ, kingI + 1});  // 아래
            directions.put("T", new int[]{kingJ, kingI - 1}); // 위
            directions.put("L", new int[]{kingJ - 1, kingI}); // 왼쪽
            directions.put("R", new int[]{kingJ + 1, kingI});  // 오른쪽
            directions.put("LB", new int[]{kingJ - 1, kingI + 1}); // 왼쪽 아래 대각선
            directions.put("LT", new int[]{kingJ - 1, kingI - 1}); // 왼쪽 위 대각선
            directions.put("RB", new int[]{kingJ + 1, kingI + 1}); // 오른쪽 아래 대각선
            directions.put("RT", new int[]{kingJ + 1, kingI - 1}); // 오른쪽 위 대각선

            String command = br.readLine();
            int[] values = directions.get(command);

            // 이동한 king의 좌표가 범위 밖이면
            if (values[0] < 0 || values[1] < 0 || values[0] >= 8 || values[1] >= 8) {
                continue;
            } else { // 벗어나지 않았으면
                if (values[0] == dolJ && values[1] == dolI) { // 이동할 king의 좌표에 dol이 위치해있으면
                    int[] returnDol = moveDol(command, dolJ, dolI);
                    // 이동할 dol의 좌표 범위가 벗어나지 않는지 확인 => 벗어나면 해당 명령 pass
                    if(returnDol[0] < 0 || returnDol[1] < 0 || returnDol[0] >= 8 || returnDol[1] >= 8) continue;

                    // 벗어나지 않으면 돌 이동
                    dolJ = returnDol[0]; dolI = returnDol[1];
                } else { // 돌이 없으면 걍 킹만 이동
                }
                kingJ = values[0];
                kingI = values[1];
            }
        }
        System.out.println(chess[kingI][kingJ]);
        System.out.println(chess[dolI][dolJ]);
    }

    private static int[] moveDol(String command, int dolJ, int dolI) {
        switch (command) {
            case "R":
                return new int[]{dolJ + 1, dolI};
            case "L":
                return new int[]{dolJ - 1, dolI};
            case "T":
                return new int[]{dolJ, dolI - 1};
            case "B":
                return new int[]{dolJ, dolI + 1};
            case "RT":
                return new int[]{dolJ + 1, dolI - 1};
            case "LT":
                return new int[]{dolJ - 1, dolI - 1};
            case "RB":
                return new int[]{dolJ + 1, dolI + 1};
            case "LB":
                return new int[]{dolJ - 1, dolI + 1};
        }
        return new int[]{dolJ, dolI};
    }
}
