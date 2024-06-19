package C07ExceptionFileParsing.AuthorException;

import java.util.Scanner;

public class AuthorController {

    public static void main(String[] args) {

        final AuthorService authorService = new AuthorService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("======== 서비스 선택 ========");
            System.out.println("(1) JOIN (2) LOGIN");
            int serviceNum = sc.nextInt();

            if (serviceNum == 1) {

                // 회원가입
                try {
                    System.out.println();
                    System.out.println("======== JOIN ========");
                    System.out.println("이름을 입력하세요.");
                    String name = sc.next();
                    System.out.println("이메일을 입력하세요.");
                    String email = sc.next();

                    // 이미 존재하는 이메일인지 확인
                    authorService.checkEmail(email);

                    System.out.println("비밀번호를 입력하세요.");
                    String pwd = sc.next();

                    // 비밀번호 글자수가 맞는지 확인
                    authorService.checkPassword(pwd);

                    // 회원가입
                    authorService.register(name, email, pwd);

                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else {

                // 로그인
                try {
                    System.out.println();
                    System.out.println("======== LOGIN ========");
                    System.out.println("이메일을 입력하세요.");
                    String email = sc.next();

                    // 이메일이 존재하는지 확인
                    authorService.checkEmail2(email);

                    System.out.println("비밀번호를 입력하세요.");
                    String pwd = sc.next();

                    // 비밀번호가 일치한지 확인
                    authorService.isRightPassword(email, pwd);

                    System.out.println("로그인이 완료되었습니다.");

                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }
}
