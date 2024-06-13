package Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BoardService {

    // 회원목록
    //static List<Author> authors = new ArrayList<>();
    // 게시글 목록
    //static List<Post> posts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println();
            System.out.println("무슨 서비스 이용할거임 1. 회원가입 2. 회원 목록 조회 3. 회원 상세 조회 " +
                    "4. 게시글 작성 5. 게시글 목록 조회 6. 게시글 상세 조회");

            int num = sc.nextInt();

            if (num == 1) {
                // 회원가입
                System.out.println("이름을 작성하세요. ");
                String inputName = sc.next();
                System.out.println("이메일을 작성하세요. ");
                String inputEmail = sc.next();
                System.out.println("비밀번호를 작성하세요. ");
                String inputPwd = sc.next();

                // 입력받은 값 담기
                Author newAuthor = new Author(inputName, inputEmail, inputPwd);
                Author.join(newAuthor);
                System.out.println("=================================");
            } else if (num == 2) {
                // 회원 목록 조회
                System.out.println();
                System.out.println("회원의 목록을 출력합니다. ");
                Author.memberAll();
                System.out.println("회원의 목록 출력 완료");
                System.out.println("=================================");
            } else if (num == 3) {
                // 회원 상세 조회
                System.out.println();
                System.out.println("상세 내용을 확인할 회원의 이메일을 입력하세요.");
                String inputEmail = sc.next();
                Long findId = findIdByEmail(Author.authors, inputEmail);
                Author.memberById(findId);
                System.out.println();

                System.out.println("=================================");
            } else if (num == 4) {
                // 게시글 작성
                System.out.println();
                System.out.println("게시글을 작성하실 분의 이메일을 입력하세요.");
                String inputEmail2 = sc.next();
                String findName = findNameByEmail(Author.authors, inputEmail2);

                System.out.println("[" + findName + "]님 글의 제목을 입력하세요.");
                String inputTitle = sc.next();
                System.out.println("[" + findName + "]님 글의 내용을 입력하세요.");
                String inputContexts = sc.next();

                Post newPost = new Post(findName, inputTitle, inputContexts, inputEmail2);
                Post.write(newPost);
                System.out.println("=================================");
            } else if (num == 5) {
                // 모든 게시글 조회
                System.out.println();
                System.out.println("모든 게시글 조회 시작");
                Post.postAll();
                System.out.println("모든 게시글 조회 완료");
                System.out.println();

                System.out.println("=================================");
            } else if (num == 6) {
                // 게시글 상세 조회
                System.out.println();
                System.out.println("상세 내용을 확인할 회원의 이메일을 입력하세요.");
                String inputEmail3 = sc.next();

                System.out.println("게시글 상세 조회를 시작합니다.");
                Post.postDetail(inputEmail3);
                System.out.println("게시글 상세 조회 완료");
                System.out.println();
            }
        }

    }

    // 이메일을 받아서 회원 id 반환
    private static Long findIdByEmail(List<Author> authors, String email) {
        for (Author author : authors) {
            if (author.getEmail().equals(email)) {
                return author.getId();
            }
        }
        return null;
    }
    // 이메일을 받아서 회원 name을 반환
    private static String findNameByEmail(List<Author> authors, String email) {
        for (Author author : authors) {
            if (author.getEmail().equals(email)) {
                return author.getName();
            }
        }
        return null;
    }
}

class Author {

    // 회원목록
    static List<Author> authors = new ArrayList<>();
    // 변수
    private static Long static_id = 0L;

    private final Long id;

    private String name;

    private String email;

    private String password;

    public Author(String name, String email, String password) {
        static_id += 1; // auto increment
        this.id = static_id;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    // getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // 회원 가입
    public static void join(Author newAuthor) {
        // id, name, email, password
        // id auto increment

        authors.add(newAuthor);
        System.out.println("[" + newAuthor.getName() + "]님의 회원가입이 완료 됐습니다.");

    }

    // 회원 전체 목록 조회
    public static void memberAll() {
        // id, email 조회

        for (Author author : authors) {
            System.out.println("id : " + author.getId() + ", email : " + author.getEmail());
        }
    }

    // 회원 상세 조회 (by id)
    public static void memberById(Long id) {
        // id, name, email password

        // id로 회원 찾기
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                System.out.println("id : " + author.getId());
                System.out.println("name : " + author.getName());
                System.out.println("email : " + author.getEmail());
                System.out.println("password : " + author.getPassword());
            }
        }
    }
}

class Post {

    // 게시글 목록
    static List<Post> posts = new ArrayList<>();

    // 변수
    private static Long static_id = 0L;

    private final Long id;

    private String writer; // 작성자 = name

    private String title;

    private String contents;

    private String email;

    public Post(String writer, String title, String contents, String email) {
        static_id += 1; // auto increment
        this.id = static_id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.email = email;
    }

    // getter
    public Long getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getEmail() {
        return email;
    }

    // 게시글 작성
    public static void write(Post newPost) {
        // id, writer, title, contents, email (내가 누군지 email로 입력받기)
        // email 가지고 author 객체 찾아와서 author 객체 그 자체를 집어넣기 (작성자로)

        posts.add(newPost);
        System.out.println("[" + newPost.getWriter() + "]님이 게시글 작성을 완료하였습니다.");
    }

    // 게시글 목록 조회
    public static void postAll() {
        // id, title

        for (Post post : posts) {
            System.out.println("id : " + post.getId() + ", title : " + post.getTitle());
        }
    }

    // 게시글 상세 조회 -> email을 받아서 조회
    public static void postDetail(String email) {
        // id, title, contents, 저자 (email or name or author_id)
        for (Post post : posts) {
            if (post.getEmail().equals(email)) {
                System.out.println();
                System.out.println("id : " + post.getId());
                System.out.println("name : " + post.getWriter());
                System.out.println("title : " + post.getTitle());
                System.out.println("contents : " + post.getContents());
            }
        }

    }
}
