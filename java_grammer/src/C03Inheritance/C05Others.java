package C03Inheritance;

public class C05Others {

    public static void main(String[] args) { // extends FinalParents 사용 못함

        // final
        final int a = 10;
        //a = 20; // final로 선언한 변수는 변경할 수 없음

        // fianl을 클래스에 붙이면 '상속 불가'한 클래스가 생성됨

        // abstract 객체 만들 수 있나 -> 놉
        // 추상클래스와 인터페이스는 구현없이 객체 생성 불가
        AbstractDog dog = new AbstractDog();
        //AbstractAnimal animal = new AbstractAnimal(); // 에러



    }
}

// 상속할 수 없는 클래스
final class FinalParents {}

// 추상 클래스
abstract class AbstractAnimal {

    void makeSound1() {
        System.out.println("동물 소리 나쟈나");
    }
    // 오버라이딩 불가 (메서드 앞에 final이 붙으면 오버라이딩 불가
    final void makeSound2() {
        System.out.println("왈왈왈");
    }

    // abstract => 자식 클래스로 하여금 오버라이딩을 강제하도록
    // 여긴 선언만 있고 구현 없음 => 자식이 구현함 / 리턴타입과 매개변수만 정의
    // abstract가 메소드에 있으면 클래스에도 붙여야함
    abstract void makeSound3();
}

class AbstractDog extends AbstractAnimal{

    @Override
    void makeSound1() {
        System.out.println("먕");
    }

    /*@Override
    void makeSound2() {} // 에러남
    */

    @Override
    void makeSound3() { // 구현해야 에러 안남
        System.out.println("먕먕먕먕ㅁ야먕ㅇ야양ㅁ야");
    }
}
