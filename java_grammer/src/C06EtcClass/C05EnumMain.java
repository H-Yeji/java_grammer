package C06EtcClass;

public class C05EnumMain {

    public static void main(String[] args) {

        EnumStudent s1 = new EnumStudent();
        s1.setName("yeji");
        //s1.setClassGrade("first_grade"); // grade에서 오타가 난다면 ?
        s1.setClassGrade(ClassGrade.c1); // 이렇게하면 실수를 줄일 수 있음

        // 더 편한 방법
        EnumStudent s2 = new EnumStudent();
        s2.setName("yeji2");
        // 여전히 타입이 String 타입이므로 임의 클래스 변수 사용하지 않을 수 있음
        // 그니까 ClassGrade.c1이 아니라 그냥 "first" 이렇게 들어가도 에러 안남
        s2.setClassGrade("first");
        // 위 같은 경우 방지 => Enum 타입 활용
        s2.setRole(Role.GENERAL_USER);
        s2.setRole(Role.ADMIN_USER); // 다른 타입은 안됨

        System.out.println(s2.getRole());
        System.out.println(s2.getRole().getClass());
        // enum 값 내부에는 저장된 순서대로 0부터 index값이 내부적으로 할당
        System.out.println(s2.getRole().ordinal());

    }
}

enum Role {

    // 각 열거형 상수는 콤마로 구분하고, 상수 목록 끝에 세미콜론 마무리
    // static final 생략되어 있는 형식
    GENERAL_USER, ADMIN_USER;

}

class ClassGrade {

    static final String c1 = "first_grade"; // final이라 수정 불가

    static final String c2 = "second_grade";

    static final String c3 = "third_grade";
}


class EnumStudent {

    private String name;

    private String classGrade;

    //private String role;
    private Role role;

    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    /*public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }*/

    // role 타입
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
