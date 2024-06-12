package C02ClassBasic;

public class C05MethodOverloading {

    public static void main(String[] args) {

        // sum 메서드에 static 안붙이면 객체 생성해서 함수 호출
        C05MethodOverloading obj = new C05MethodOverloading();
        System.out.println(obj.sum(10, 20)); // 30
        System.out.println(obj.sum(10, 20, 30)); // 60

        // static 붙이면 그냥 가능
        //System.out.println(sum(10, 20));
    }

    // 접근제어자 기본 : default (안붙이면) => 같은 패키지 내에서 접근 가능
    int sum(int a, int b) {
        return a + b;
    }

    // 인자의 개수가 다르거나 반환 타입이 다르면 같은 메서드명도 가능 => 메소드 오버로딩
    int sum(int a, int b, int c) {
        return a + b + c;
    }

}
