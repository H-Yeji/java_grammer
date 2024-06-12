package C02ClassBasic;

public class C01Method {

    // return type : int
    // input 값 2개 지정
    // 메서드 구성 요소 : 매개변수, 리턴타입, 접근제어자(public), 클래스메서드 여부 (static)
    public static int sumAcc(int start, int end) {

        int total = 0;
        for (int i = start; i <= end; i++) {
            total += i;
        }

        return total;
    }

    public static void main(String[] args) {

        // 같은 코드를 사용해서 코드의 불필요한 중복이 발생할 때
        // 반복 기능을 별도로 분리시켜 사용하기 위해 사용하는 것 => method
        System.out.println(sumAcc(100, 200));

        // 클래스 명.메소드 : 기본방식
        System.out.println(C01Method.sumAcc(100, 200));
        // 같은 클래스 내에서는 클래스명 생략 가능
        System.out.println(sumAcc(100, 200));

    }
}
