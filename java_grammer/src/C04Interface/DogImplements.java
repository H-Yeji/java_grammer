package C04Interface;

public class DogImplements implements AnimalInterface1{

    @Override
    public void makeSound() {
        System.out.println("왈왈왈");
    }
}

class DogMultiImplements implements AnimalInterface1, AnimalInterface2{

    @Override
    public void makeSound() {
        System.out.println("먕먀염ㅇ명멍멍어엉멍멍");
    }

    @Override
    public String play(String a, String b) {
        return a+"가"+b+"랑 안논대";
    }
}