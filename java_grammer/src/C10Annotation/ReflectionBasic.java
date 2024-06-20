package C10Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionBasic {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        // 런타임 상황에서 자바가 진행되는 과정 ?
        // 자바가 리플렉션 기술을 통해 진행되는 과정

        // 객체 생성방법 1. 기존의 방식과 메서드 호출
        Calculator calculator = new Calculator("Samsung");
        calculator.sayHello(); // my name is Samsung

        // 객체 생성방법2. 런타임 환경에서 리플렉션 기술을 통해 객체 생성 및 메서드 호출
        // <?>는 제네릭 표현으로 어떤 클래스 타입도 가능하다는 표현
        // getClass 메서드는 런타임 시점에 calculator라는 객체의 타입을 가져오는 메서드
        Class<?> myClass = calculator.getClass();

        // 객체 생성 2-1)
        Calculator cal1 = (Calculator) myClass.getConstructor(String.class).newInstance("Samsung");
        // 메서드 생성
        Method cal1Method = myClass.getMethod("sayHello");
        cal1Method.invoke(cal1);

        // 객체 생성 2-2)
        // 계산기 클래스에서 constructor 뒤져서 String인자인거 가져와서 Caiso담고 인스턴스로 생성해서 저장
        Calculator cal2 = Calculator.class.getConstructor(String.class).newInstance("Casio");
        // 자바 동작 방법 => Calculator 클래스의 method 뒤져서 sayHello 가져와서 그걸 invoke => 실행시킴
        Method cal2Method = Calculator.class.getMethod("sayHello");
        // 가져온 인스턴스를 담아서 invoke (실행)
        // 그니까 위에서 실행할 메서드 가져오고, 객체 가져와서 실행하는 것 => 자바에서 객체 생성하고 실행하는 방법
        cal2Method.invoke(cal2);

        // 리플렉션 기술을 통해 필드 접근 및 수정
        // 마찬가지로 계산기의 필드를 뒤져서 name을 가져와
        Field nameField = Calculator.class.getDeclaredField("name");
        // 가져온 필드를 true로 바꿔서 접근 가능하도록 변경 -> 수정할 수 있도록
        nameField.setAccessible(true);
        // 그럼 이제 Samsung->Casio로 변경할 수 있음
        nameField.set(cal1, "Casio");
        // 바꾼 객체 실행해보기 (출력으로 확인)
        cal1Method.invoke(cal1);
    }
}
class Calculator {

    private String name;

    public Calculator() {}

    public Calculator(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("my name is " + this.name);
    }
}
