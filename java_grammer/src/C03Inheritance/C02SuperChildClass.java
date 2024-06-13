package C03Inheritance;

public class C02SuperChildClass extends SuperParents{

    int a;
    int c;

    C02SuperChildClass() {

        // super() : 부모 클래스의 생성자를 의미
        // super.변수명 : 부모 클래스의 변수명 의미
        super(30);
        a = 10;
        c = 20;
    }

    public static void main(String[] args) {
        C02SuperChildClass c1 = new C02SuperChildClass();
        c1.display2();
    }

    void display2() {
        System.out.println(a); // 자식 10이 출력됨
        System.out.println(super.a); // 부모 30이 출력됨
    }

}

class SuperParents {

    int a;

    // 생성자
    SuperParents(int a) {
        this.a = a;
    }

    void display() {
        System.out.println("부모 클래스");
    }
}
