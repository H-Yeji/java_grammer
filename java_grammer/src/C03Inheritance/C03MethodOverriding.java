package C03Inheritance;

public class C03MethodOverriding {

    public static void main(String[] args) {

        Dog myDog = new Dog();
        myDog.sound2();

        // 상속관계일 때 부모 클래스 타입을 자식 클랙스 객체의 타입으로 지정 가능
        Animal myDog2 = new Dog();
        myDog2.sound();
        // myDog2.sound2(); // 컴파일 에러 발생 -> sound2가 Animal에 없음
    }
}

class Animal {
    void sound() {
        System.out.println("동물은 소리 냄");
    }
}

class Dog extends Animal {

    void sound() {
        System.out.println("멍");
    }

    void sound2() {
        System.out.println("머엄ㅇ멍");
    }
}

class Cat extends Animal {

    void sound() {
        System.out.println("먕");
    }
}