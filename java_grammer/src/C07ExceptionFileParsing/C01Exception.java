package C07ExceptionFileParsing;

import java.sql.SQLException;
import java.util.Scanner;

public class C01Exception {

    public static void main(String[] args) {

        System.out.println("나눗셈 프로그램입니댜");
        Scanner sc = new Scanner(System.in);

        // 예외가 발생할 것으로 예상되는 코드에 try로 감싸고
        // 예외가 발생했을 때 대응하는 코드를 catch로 작성
        try {
            System.out.println("분자 입력");
            int head = Integer.parseInt(sc.nextLine());
            System.out.println("분모 입력 ");
            int tail = Integer.parseInt(sc.nextLine());

            int result = head/tail;
            System.out.println("나눈 결과값 " + result); // 0으로 나누면 예외발생

        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없음");
            // 예외가 발생된 내역을 로그를 남기기 위함
            //e.printStackTrace();
            System.out.println(e.getMessage()); // 에러 메시지 출력
        } catch (NumberFormatException e) {
            System.out.println("숫자에 맞는 값을 입력해주세요.");
        } catch (Exception e) {
            System.out.println("예외가 발생했습니다. ");
        } finally {
            System.out.println("감사합니다.");
        }

        // login2 호출
        try {
            login2("1234");
        } catch (SQLException e) {
            System.out.println("밀번호가 너무 짧습니다. ");
        }

    }

    // throws : 예외처리 위임을 명시
    // unchecked 예외에서는 throws 키워드가 예외사항을 명시하는 용도로만 사용

    /**
     * checked : 다른 시스템과의 네트워크 (Db 조회)
     * unchecked : 프로그램 자체의 이슈
     *
     * checked exception(sql exception등) : 외부 시스템 통신 -> 예외처리 강제 -> 예외처리 하든 throws 하든
     * unchecked exception(index out of bounds 등) : 그외 -> 예외처리 선택 -> throws 선택
     * */
    static void login(String password) throws IllegalArgumentException, RuntimeException {
        if (password.length() < 10) {
            // throw new : 예외를 강제로 발생
            // 예외는 기본적으로 메소드를 호출한 쪽에 전파
            // unchecked 예외는 예외처리가 강제되지 않음
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다. ");
        }
    }
    static void login2(String password) throws SQLException {

        // 방법1 - 직접 예외처리
        /*try {
            if (password.length() < 10) {
                throw new SQLException("Db 조회 상황에서 예외가 발생 ");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }*/

        // 방법2 - 메서드를 호출한 쪽에 위임
        if (password.length() < 10) {
            throw new SQLException("db 조회 상황에서 예외 발생 ");
        }
    }

}
