package C02ClassBasic;

// 같은 패키지 내의 다른 클래스
public class C03Class {

    public static void main(String[] args) {
        // 다른 클래스라 클래스명.메서드명()으로 호출
        System.out.println(MyCalculator.sum(20, 10));

        // A부서의 매출
        // 처음에 매출 20원 발생
        MyCalculator.sumAcc(20);
        System.out.println("20원 매출 : " + MyCalculator.total);
        // 추가 매출 30원 발생
        MyCalculator.sumAcc(30);
        System.out.println("30원 추가 매출 : " + MyCalculator.total);
        // 추가 매출 40원 발생
        MyCalculator.sumAcc(40);
        System.out.println("40원 추가 매출 : " + MyCalculator.total);


        // 객체를 사용한 회계 프로그램 => static을 사용하지 않아서 각각 객체로 담아 활용 가능
        // 객체 고유의 메모리 공간 할당
        // A회사 매출
        MyCalculatorInstance m1 = new MyCalculatorInstance();
        // 객체 메서드 호출 방식 : 클래스변수.메서드명()
        m1.sumAcc(10);
        m1.sumAcc(20);
        m1.sumAcc(30);
        System.out.println("m1의 total : " + m1.total);
        MyCalculatorInstance m2 = new MyCalculatorInstance();
        m2.sumAcc(100);
        m2.sumAcc(200);
        m2.sumAcc(300);
        System.out.println("m2의 total : " + m2.total);

        // 사람 객체 생성
        C04Person person1 = new C04Person();
        // 변수값에 직접 접근해서 값을 할당하는 방식
        /*person1.name = "lee";
        person1.email = "'lee@test.com";
        person1.age = 18;
        person1.eating();
        System.out.println("이름 : " + person1.name + "이메일 : " + person1.email);*/ // private 붙여서 에러

        // 일반적인 패턴 : 변수값에 직접 접근하지 않음
        // 의도를 명확히 한 메서드를 통해 변수값을 할당하고 가져옴
        // 그럼 다른 클래스에서 접근 못하게 막아야지 -> private 붙여서
        person1.eating(); // null이 밥을 먹음ㅎ
        person1.setName("yeji"); // 이름을 세팅해서 > null이 아니라 yeji가 eating에 출력됨
        System.out.println(person1.getName()); // yeji
        person1.eating(); // yeji이 밥을 먹음ㅎ

    }
}

class MyCalculator {

    // static이 붙어있는 변수는 클래스 변수
    // static이 붙어있지 않으면 객체 변수
    static int total = 0;
    static int sum(int a, int b) {
        return a + b;
    }

    static void sumAcc(int a) {
        total += a;
    }
    static int minus (int a, int b) {
        return a - b;
    }
}

class MyCalculatorInstance {

    // static이 붙어있는 변수는 클래스 변수
    // static이 붙어있지 않으면 객체 변수
    int total = 0;
    int sum(int a, int b) {
        return a + b;
    }

    void sumAcc(int a) {
        this.total += a; // this는 객체 자기 자신
    }
    int minus (int a, int b) {
        return a - b;
    }
}