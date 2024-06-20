package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class C03JsonParsing1 {

    /**
     * 자바 객체 -> json : 직렬화
     * json -> 자바 객체 : 역직렬화
     * jsoon 파일 read (NIO/IO 패키지) -> 문자열 read -> 파싱 (역직렬화)
     */
    /**
     * readTree : JsonNode 트리구조로 객체 return
     * readValue : 원하는 객체로 변환해서 return
     */
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Path filePath = Paths.get("C:\\Users\\Playtdata\\Desktop\\Yeji\\java\\java_grammer\\src\\C07ExceptionFileParsing\\test_data1.json");

        String jsonString = Files.readString(filePath);
        System.out.println(jsonString); // 객체가 아니고 문자열 형태

        // 객체로 받기 위해 objectMapper 사용
        // readTree : 트리구조의 JsonNode로 변환
        // 트리구조의 장점은 유연함
        JsonNode data1 = objectMapper.readTree(jsonString); // jsonNode -> 트리구조의 형태로 반환된 것
        Map<String, String> studentMap = new HashMap<>();
        studentMap.put("id", data1.get("id").asText());
        studentMap.put("name", data1.get("name").asText());
        studentMap.put("classNum", data1.get("classNum").asText());
        studentMap.put("city", data1.get("city").asText());
        System.out.println(studentMap); // {city=seoul, name=yeji, id=1, classNum=1}


        // readValue : 바로 객체로 변환
        Map<String, String> studentMap2 = objectMapper.readValue(jsonString, Map.class);
        System.out.println(studentMap2); // {id=1, name=yeji, classNum=1, city=seoul}

        Student student =  objectMapper.readValue(jsonString, Student.class);
        System.out.println(student);
        /**
         * id : 1
         * name : yeji
         * classNum : 1
         * city : seoul
         */

    }
}

// objectMapper는 getter 또는 setter 메서드명을 통해 필드값 유추
// 실제 값의 setting은 reflection이라는 기술을 통해 변수 값을 할당
class Student {

    private int id;

    private String name;

    private String classNum;

    private String city;

    // getter를 통해서 접근
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassNum() {
        return classNum;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return  "\nid : " + id + "\nname : " + name + "\nclassNum : " + classNum + "\ncity : " + city;
    }
}