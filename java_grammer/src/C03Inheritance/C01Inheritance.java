package C03Inheritance;

// extends 키워드를 통해 상속관계
public class C01Inheritance extends Parents {

    int c = 30;

    public static void main(String[] args) {

        C01Inheritance c1 = new C01Inheritance();
        // 자식 클래스라 하더라도, private 변수는 상속 및 접근 불가 (b는 못불러옴)
        System.out.println(c1.a);
        System.out.println(c1.c);
        c1.parentMethod(); // 재정의된 자식메서드 출력

    }

    // 부모 메서드 재정의 : overriding
    // 성능의 최적화를 위해 붙여주는게 좋은 것으로 알려져 있음
    @Override
    void parentMethod() {
        System.out.println("부모 클래스 아니고 자식 클래스");
    }
    void childMethod() {
        System.out.println("자식 클래스");
    }
}

class Parents {

    // static 안붙음 -> 인스턴스 메서드
    int a = 10;

    private int b = 20;

    void parentMethod() {
        System.out.println("부모 클래스");
    }
}
