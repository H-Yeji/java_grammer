package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class C05JsonParsing3 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Spring에서는 RestTemplate을 통해 Http 요청하고
        // 여기서는 java에 내장된 http 클라이언트 사용
        // http 클라이언트가 java에 내장
        // 외부 데이터(json) 받아오기
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String posts = response.body();
        //System.out.println(posts);

        // 트리 생성
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonList = objectMapper.readTree(posts); // String 타입으로 받아온 json 파일을 담기 -> 트리 생성
        List<Post> postList = new ArrayList<>();

        for (JsonNode j : jsonList) {
            Post tmpPost = objectMapper.readValue(j.toString(), Post.class);
            postList.add(tmpPost);
        }

        // postList 객체를 json으로 직렬화
        String postJson = objectMapper.writeValueAsString(postList);
        System.out.println(postList);
    }
}

class Post {

    private int userId;

    private int id;

    private String title;

    private String body;

    // getter
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "\n\n[작성자: " + userId + ", id: " + id + "]\n제목: " + title + "\n내용: " + body;
    }
}
