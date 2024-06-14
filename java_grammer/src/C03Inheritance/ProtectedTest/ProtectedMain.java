package C03Inheritance.ProtectedTest;

import C03Inheritance.C04ProtectedClass;

// ProtectedClass
public class ProtectedMain extends C04ProtectedClass {

    public static void main(String[] args) {

        // ⭐⭐ 차이 확인하기
        // C04ProtectedClass로 객체 만들어서 사용하는건 상속과 상관없이 그냥 객체를 가져다 쓰는 것 -> protected 사용 불가
        // ProtectedMain으로 객체를 만들어서 사용하는 것은 ProtectedClass를 '상속'받는 것 -> protected 사용 가능

        // ProtectedClass로 객체 만드는 경우
        C04ProtectedClass c1 = new C04ProtectedClass();
        System.out.println(c1.st4); // public인 st4만 가능
        // c1.s2와 c1.s3는 안됨 =>protected도 안됨


        // ProtectedMain으로 객체를 만드는 경우
        ProtectedMain p1 = new ProtectedMain();
        // 상속한 객체에서 protected 접근 가능 (ProtectedClass에서 생성한건 안됨)
        System.out.println(p1.st3); // protected 접근 가능
    }
}
