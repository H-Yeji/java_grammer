package C06EtcClass;

public class C01Math {

    public static void main(String[] args) {

        // Math. -> static 메서드 (클래스 메서드)
        // 0.0 ~ 1.0미만의 임의의 double형 반환
        double value = Math.random();
        System.out.println(value);

        for (int i = 0; i < 6; i++) {
            int random = (int)(Math.random()*100);
            System.out.println(random);
        }

        // abs() : 절대값 반환
        System.out.println(Math.abs(-5));

        // 올림 : ceil(), 내림 : floor(), 반올림 : round()
        System.out.println(Math.ceil(5.7)); // 6.0 (double)
        System.out.println(Math.floor(5.7)); // 5.0 (double)
        System.out.println(Math.round(5.7)); // 6

        // min, max
        System.out.println(Math.max(5, 10));
        System.out.println(Math.min(5, 10));

        // pow : 제곱, sqrt : 제곱근
        System.out.println(Math.pow(3, 3)); // 3^3 // 27.0
        System.out.println(Math.sqrt(9)); // 3.0

    }
}
