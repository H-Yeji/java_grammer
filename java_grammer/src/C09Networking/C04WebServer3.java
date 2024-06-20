package C09Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Arrays;

public class C04WebServer3 {

    public static void main(String[] args) throws IOException, SQLException {

        // author 테이블 생성
        // id, name, email, password pk(id)

        // 사용자가 localhost:8081?id=1 요청 시, name, email, password 응답
        // 사용자가 localhost:8081?name=hong&email=hong@naver.com => name, email, password 응답

        // mysql 드라이버가 필요
        String url = "jdbc:mysql://localhost:3306/board1?useSSL=false";
        String userName = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("DB 연결 성공");

        // 소켓 연결
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


            if (infos.contains("?")) {
                String st1 = infos.split("\\?")[1]; // id=1
                String[] stArr = st1.split("&"); //&을 기준으로 잘라서 넣음

                for (String s : stArr) { // =로 나누기
                    int inputId = 0;
                    String inputName;
                    String[] keyValue = s.split("="); // name=yeji

                    if (keyValue[0].equals("id")) { // id면
                        inputId = Integer.parseInt(keyValue[1]);

                        Statement st = con.createStatement();
                        String myQuery = "SELECT * FROM author where id = " + inputId;
                        ResultSet rs = st.executeQuery(myQuery);

                        int findId; String findName=""; String findEmail=""; String findPassword="";
                        while (rs.next()) {
                            findId = rs.getInt("id");
                            findName = rs.getString("name");
                            findEmail = rs.getString("email");
                            findPassword = rs.getString("password");
                        }

                        System.out.println("이름: " + findName + ", 이메일: " + findEmail + ", 비밀번호: " + findPassword);

                    } else if (keyValue[0].equals("name")) {
                        inputName = keyValue[1];
                        Statement st = con.createStatement();
                        String myQuery = "SELECT * FROM author Where name ='"+ inputName +"';";
                        ResultSet rs = st.executeQuery(myQuery);

                        int findId; String findName=""; String findEmail=""; String findPassword="";
                        while (rs.next()) {
                            findId = rs.getInt("id");
                            findName = rs.getString("name");
                            findEmail = rs.getString("email");
                            findPassword = rs.getString("password");
                        }
                        System.out.println("이름: " + findName + ", 이메일: " + findEmail + ", 비밀번호: " + findPassword);
                    }
                }
            }

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
