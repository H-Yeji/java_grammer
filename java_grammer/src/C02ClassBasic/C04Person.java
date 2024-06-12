package C02ClassBasic;

public class C04Person {

    private String name;
    private String email;
    private int age;

    public void eating() {
        System.out.println(this.name + "이 밥을 먹음ㅎ");
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
    // getter
    public String getName() {
        return this.name;
    }
}


