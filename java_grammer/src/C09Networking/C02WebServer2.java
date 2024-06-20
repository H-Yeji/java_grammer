package C09Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C02WebServer2 {

    public static void main(String[] args) throws IOException {

        // 소켓이란 서버와 사용자가 통신을 하기 위한 네트워크 통신의 끝점을 나타내는 개념
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("8081 서비스 시작");

        while (true) { // 끊기면 안됨

            // accept() : 클라이언트의 연결 요청을 수락
            Socket socket = serverSocket.accept();
            //System.in은 터미널(키보드에서)에 작성하는 것  -> 이건 터미널에서 하는 것 아니고 소켓에서 하는 것
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            // sb에 line 문자열 담기
            while ((line= br.readLine()) != null && !line.isEmpty()) {
                sb.append(line + "\n");
            }

            String requestString = sb.toString();
            // 첫번째 라인 자르기
            String firstLine = requestString.split("\n")[0]; // GET /?name=yeji HTTP/1.1
            String infos = firstLine.split(" ")[1]; // /?name=yeji (get이 0번째)
            System.out.println(infos);

            String id = ""; String name="";
            if (infos.contains("?")) {
                String st1 = infos.split("\\?")[1];
                String[] stArr = st1.split("&"); //&을 기준으로 잘라서 넣음
                for (String s : stArr) { // =로 나누기
                    String[] keyValue = s.split("="); // name=yeji
                    if (keyValue[0].equals("id")) {
                        id = keyValue[1];
                    } else if (keyValue[0].equals("name")) {
                        name = keyValue[1];
                    }
                }
            }
            System.out.println("id: " + id + ", name: " + name);
            //System.out.println(requestString);
            // 응답 받고 화면에 출력될 결과 (localhost:8081)
            String httpResponse = "HTTP/1.1 200\r\n\r\n" + "hello YEJI";
            // 그냥 문자열이면 안됨
            // hello yeji 앞에는 http 규격에 맞춰서 넣어주기 -> 그래야 화면에 나타남
            socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();
        }
    }
}
