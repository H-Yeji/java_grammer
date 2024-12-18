package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ19583 {
    // 실버2 싸이버개강총회
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 개강총회 시간 입력
        int startHour = 0; int startMin = 0;
        int finHour = 0; int finMin = 0;
        int closeRoomHour = 0; int closeRoomMin = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            String time = st.nextToken();
            String[] split = time.split(":");
            if (i == 0) {
                startHour = Integer.parseInt(split[0]);
                startMin = Integer.parseInt(split[1]);
            } else if (i == 1) {
                finHour = Integer.parseInt(split[0]);
                finMin = Integer.parseInt(split[1]);
            } else {
                closeRoomHour = Integer.parseInt(split[0]);
                closeRoomMin = Integer.parseInt(split[1]);
            }
        }

        Set<String> inputName = new HashSet<>();
        Set<String> outputName = new HashSet<>();
        while (true) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty() || line.equalsIgnoreCase("END")) {
                break;
            }

            st = new StringTokenizer(line);
            // 시간
            String time = st.nextToken();
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);
            // 이름
            String name = st.nextToken();

            if (hour < startHour || (hour == startHour && min <= startMin)) {
                inputName.add(name);
            }
            if ((hour > finHour || (hour == finHour && min >= finMin))
            && (hour < closeRoomHour || (hour == closeRoomHour && min <= closeRoomMin))) {
                outputName.add(name);
            }
        }
        int result = 0;
        for (String name: inputName) {
            if (outputName.contains(name)) result++;
        }
        System.out.println(result);
    }
}
