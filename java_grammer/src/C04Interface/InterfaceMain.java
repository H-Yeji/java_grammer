package C04Interface;

public class InterfaceMain {

    public static void main(String[] args) {

        CatImplements cat1 = new CatImplements();
        cat1.makeSound(); // 야옹

        DogImplements dog1 = new  DogImplements();
        dog1.makeSound(); // 왈왈왈

        // 다형성 : 하나의 객체가 여러 개의 참조변수를 가질 수 있음을 의미
        AnimalInterface1 cat2 = new CatImplements();
        cat2.makeSound(); // 야옹

        AnimalInterface1 dog2 = new DogImplements();
        dog2.makeSound(); // 왈왈왈


        CatMultiImplements cat3 = new CatMultiImplements();
        cat3.makeSound(); // 야옹야ㅗㅇㅇ
        System.out.println(cat3.play("고먕이","먕먕이")); // 고먕이와먕먕이가 같이 노나봐

        DogMultiImplements dog3 = new DogMultiImplements();
        dog3.makeSound(); // 먕먀염ㅇ명멍멍어엉멍멍
        System.out.println(dog3.play("고먐미", "먐먐미")); // 고먐미가먐먐미랑 안논대

        // 만약 둘 다 implements했는데 왼쪽에 CatMultiImplements 위치에 참조 타입을
        // AnimalInterface1을 하면 makeSound만 정의할 수 있고
        // AnimalInterface2를 하면 play()만 정의할 수 있음
        // 객체는 오른쪽에 작성한 MultiImplements 타입이지만, 사용 기능은 왼쪽에 작성한 참조 타입의 영향을 받음


        // 기본적으로 추상클래스, 인터페이스는 객체 생성이 불가능하나,
        // 익명 내부 클래스 방식으로 생성 가능 ⭐
        AnimalInterface1 ai1 = new AnimalInterface1() { // 객체 생성과 동시에 내부에 메서드 생성하면 가능
            @Override
            public void makeSound() {
                System.out.println("hello");
            }
        };
        ai1.makeSound();





    }
}
