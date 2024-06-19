package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class C04JsonParsing2 {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Path filePath = Paths.get("C:\\Users\\Playtdata\\Desktop\\Yeji\\java\\java_grammer\\src\\C07ExceptionFileParsing\\test_data2.json");

        // 트리 생성
        String jsonString = Files.readString(filePath);
        JsonNode jsonList = objectMapper.readTree(jsonString);
        List<Student> studentList = new ArrayList<>();

        for (JsonNode j : jsonList) {
            Student tmpStudent = objectMapper.readValue(j.toString(), Student.class);
            studentList.add(tmpStudent);
        }
        System.out.println(studentList);

    }
}

