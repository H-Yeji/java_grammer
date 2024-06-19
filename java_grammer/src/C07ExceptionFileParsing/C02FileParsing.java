package C07ExceptionFileParsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.List;

public class C02FileParsing {

    public static void main(String[] args) throws IOException {

        // Stream : 전송해주는 흐름

        // io 패키지
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 한 줄 읽기
        System.out.println(input);*/

        // 파일에서 읽기 ( 상대경로)
        /*BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Playtdata\\Desktop\\Yeji\\java\\java_grammer\\src\\C07ExceptionFileParsing\\test_file.txt"));
        System.out.println(br2.readLine());
        String line = br2.readLine();
        while (line != null) {
            System.out.println(line);
        }*/


        // NIO 패키지를 사용한 파일처리
        /*Path filePath = Paths.get("C:\\Users\\Playtdata\\Desktop\\Yeji\\java\\java_grammer\\src\\C07ExceptionFileParsing\\test_file.txt");

        if (!Files.exists(filePath)) {
            System.err.println("File does not exist: " + filePath.toAbsolutePath());
            return;
        }

        try {

            // 문자열 통째로 read
            String st1 = Files.readString(filePath);
            System.out.println(st1);

            // 문자열을 각 라인을 잘라 list형태로 read
            List<String> st2 = Files.readAllLines(filePath);
            for (String s : st2) {
                System.out.println(s + "선수");
            }

        } catch (IOException e) {

            e.printStackTrace();
        }*/

        // 파일쓰기
        // append(추가), write(덮어쓰기)
        // create_new (생성)
        Path filePath = Paths.get("C:\\Users\\Playtdata\\Desktop\\Yeji\\java\\java_grammer\\src\\C07ExceptionFileParsing\\test_file.txt");

        if (Files.exists(filePath)) {
            Files.write(filePath, "예지\n".getBytes(), StandardOpenOption.APPEND);
        } else {
            Files.write(filePath, "".getBytes(), StandardOpenOption.CREATE_NEW); // 파일 없으면 생성
        }

    }
}
