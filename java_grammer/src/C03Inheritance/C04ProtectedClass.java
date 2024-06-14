package C03Inheritance;

/**
 * 클래스 => public 과 default만 존재
 * ----------------------------------
 * 변수와 메서든 => 4가지 접근제어자 존재
 * public : 프로젝트 전체에서 접근 가능
 * protected : 패키지를 벗어나더라도 상속관계인 경우에는 접근 가능
 * default : 패키지 내에서만 접근 가능
 * private : 클래스 내에서만 접근 가능
 */
public class C04ProtectedClass {

    private String st1 = "hello java1";

    String st2 = "hello java2";

    protected String st3 = "hello java3";

    public String st4 = "hello java4";


}
