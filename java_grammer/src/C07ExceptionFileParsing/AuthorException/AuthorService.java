package C07ExceptionFileParsing.AuthorException;

public class AuthorService {

    private final AuthorRepository authorRepository = new AuthorRepository();

    // 회원가입
    public void register (String name, String email, String password) {

        Author newAuthor = new Author(name, email, password);
        authorRepository.add(newAuthor);

    }

    // 회원가입을 위해 email 확인
    public void checkEmail(String email) {

        if (authorRepository.isPresentEmail(email)) {
            throw new RuntimeException("존재하는 이메일 입니다.");
        }
    }
    // 로그인을 위해 email 확인
    public void checkEmail2(String email) {
        if (!authorRepository.isPresentEmail(email)) { // 존재하지 않으면
            throw new RuntimeException("존재하지 않은 이메일입니다.");
        }
    }
    // 회원가입을 위해 비밀번호 자리수 확인
    public void checkPassword(String pwd) {

        if (pwd.length() <= 5) {
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
        }
    }
    // 로그인을 위해 비밀번호가 맞는지 확인
    public void isRightPassword(String email, String pwd) {

        if (!authorRepository.isRightPassword(email, pwd)) { // 비밀번호가 맞지 않으면
            throw new RuntimeException("비밀번호가 맞지 않습니다.");
        }
    }
}
