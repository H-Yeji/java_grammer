package C07ExceptionFileParsing.AuthorException;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    static List<Author> authors = new ArrayList<>(); // author을 담을 list 생성

    public static void add (Author newAuthor) { // 리스트에 넣기

        authors.add(newAuthor);
        System.out.println("회원가입이 완료되었습니다.");
    }

    public static boolean isPresentEmail (String email) {

        for (Author a : authors) {
            if (a.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRightPassword (String email, String password) {

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
