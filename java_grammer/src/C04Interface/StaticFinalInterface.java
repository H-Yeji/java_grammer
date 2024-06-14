package C04Interface;

public class StaticFinalInterface {

    public static void main(String[] args) {

        MyInterface m1 = new MyImplements();
        m1.methodA();
        // MyImplements에 my_constant변수가 상속(static final)
        System.out.println(MyImplements.my_constant);
    }


}

// 인터페이스
interface MyInterface {

    // 아래 변수는 컴파일타입에 static final이 붙음
    int my_constant = 10;

    void methodA();
}

// 구현 클래스
class MyImplements implements MyInterface {

    @Override
    public void methodA() {
        System.out.println("hello world");
    }
}

