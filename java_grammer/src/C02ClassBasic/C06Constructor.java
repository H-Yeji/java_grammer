package C02ClassBasic;

public class C06Constructor {

    public static void main(String[] args) {

        Calendar calendar = new Calendar("2024", "06", "12");
        /*calendar.setYear("2024");
        calendar.setMonth("06");
        calendar.setDay("12");*/
        System.out.println(calendar.getYear() + "년 " + calendar.getMonth() + "월 " + calendar.getDay() + "일 ");

    }
}

class Calendar {
    String year;
    String month;
    String day;

    // new 호출될 때 ()안에 인자가 없어서 기본생성자 필요
    public Calendar() {}

    public Calendar(String year, String month) {
        this.year = year;
        this.month = month;
    }

    // 생성자 : 클래스명과 동일, 초기화하고 싶은 변수명 나열
    public Calendar(String year, String month, String day) { // new로 호출하는 시점에 생성자 호출됨
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // setter
    /*public void setYear(String year) {
        this.year = year;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public void setDay(String day) {
        this.day = day;
    }*/

    // getter
    public String getYear() {
        return year;
    }
    public String getMonth() {
        return month;
    }
    public String getDay() {
        return day;
    }

}
