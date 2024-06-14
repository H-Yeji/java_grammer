package C03Inheritance;

public class C04ProtectedTest {

    public static void main(String[] args) {

        C04ProtectedClass pc = new C04ProtectedClass();

        // public 접근 가능
        System.out.println(pc.st4); // st4 : public -> 접근 가능
        System.out.println(pc.st3); // st3 : default -> default
        System.out.println(pc.st2); // st2 : 아무것도 안써있으면 default
        // System.out.println(pc.st1); // st1 : private -> 접근 불가능
    }

}
