package C07ExceptionFileParsing.AuthorException;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private static final List<Author> authors = new ArrayList<>(); // author을 담을 list 생성

    // author 목록에 author 추가
    public void add (Author newAuthor) { // 리스트에 넣기

        authors.add(newAuthor);
        System.out.println("회원가입이 완료되었습니다.");
    }

    // authors에 해당 이메일이 존재하는지 여부 반환
    public boolean isPresentEmail (String email) {

        for (Author a : authors) {
            if (a.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    // 해당 메일과 일치한 author과 비밀번호가 같은지 여부 반환
    public boolean isRightPassword (String email, String password) {

        for (Author a : authors) {
            if (a.getEmail().equals(email)) {
                if (a.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

}
