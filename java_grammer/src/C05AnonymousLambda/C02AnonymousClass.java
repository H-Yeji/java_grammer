package C05AnonymousLambda;

public class C02AnonymousClass {

    public static void main(String[] args) {

        // AbstractAnimal 상속한 클래스가 별도로 존재하지 않고,
        // 익명의 클래스가 만들어짐과 동시에 익명 객체 생성
        AbstractAnimal a1 = new AbstractAnimal() {
            @Override
            void makeSound2() { // abstract가 붙어있는 메서드를 만들어줌

            }
        };

        // 익명 객체가 구현 메서드가 1개밖에 없을 때에 람다 표현식(화살표 함수)으로 표현 가능
        /*Animal a2 = new Animal() { // interface라서 자동 구현됨
            @Override
            public void makeSound() {

            }
        };*/
        // 위 코드를 람다식으로 이렇게 표현할 수 있음
        Animal a2 = (c)-> System.out.println("동물 소리 냅니다." + c);
        a2.makeSound(10);
        /**
         * 설명 ) () 부분에 매개변수를 지정해 구현체에서 활용
         * makeSound()에 매개변수가 없으므로 ()를 비워둠
         * makeSound()에 매개변수 int a를 추가해주면 ()안에 갯수만큼 변수 넣어주기 (여러개일 때, 순서도 맞아야 함)
         * -> 오른쪽에 구현부를 작성하는 것
         */

        // 익명객체 생성
        Animal2 a3 = (a, b, c) -> { // 내부 코드가 두 줄 이상이면 {} 사용
            return (a + b + c);
        };
        // Animal2 a5 = (a, b, c) -> a + b + c; -> 한줄로 가능
        System.out.println(a3.makeSound("hello ", "java ", 1));
        Animal2 a4 = new Animal2() {
            @Override
            public String makeSound(String a, String b, int c) {
                return a + b + c;
            }
        };
        System.out.println(a4.makeSound("hello ", "java ", 3));

    }
}

interface Animal {

    void makeSound(int a);
}

interface Animal2 {
    String makeSound(String a, String b, int c);
}

abstract class AbstractAnimal {

    void makeSound1() {};

    abstract void makeSound2();
}
