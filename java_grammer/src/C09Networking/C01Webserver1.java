package C09Networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C01Webserver1 {

    public static void main(String[] args) throws IOException {

        // 소켓이란 서버와 사용자가 통신을 하기 위한 네트워크 통신의 끝점을 나타내는 개념
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("8081 서비스 시작");

        while (true) { // 끊기면 안됨

            // accept() : 클라이언트의 연결 요청을 수락
            Socket socket = serverSocket.accept();

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
