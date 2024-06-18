package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C02Calendar {

    public static void main(String[] args) {

        // java.util 패키지의 Calendar 클래스
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        System.out.println(calendar.get(Calendar.YEAR)); // 2024
        System.out.println(calendar.get(Calendar.MONTH) + 1); // 0부터 시작해서 +1해주기
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 18
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 3
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

        System.out.println("=============java.time=============");
        // java.time 패키지 : Local ~ 클래스
        // 날짜(LocalDate) - date(mariadb), 시간(LocalTime)
        // 날짜와 시간 (LocalDateTime)  - dateTime(mariadb)
        LocalDate presentDate = LocalDate.now();
        System.out.println(presentDate.getYear());
        System.out.println(presentDate.getMonth());
        System.out.println(presentDate.getDayOfMonth());
        System.out.println(presentDate.getDayOfWeek());
        /**
         * 2024
         * JUNE
         * 18
         * TUESDAY
         */

        LocalTime presentTime = LocalTime.now();
        System.out.println(presentTime);
        System.out.println(presentTime.getHour());
        System.out.println(presentTime.getMinute());
        System.out.println(presentTime.getSecond());
        /**
         * 10:34:55.212605300
         * 10
         * 34
         * 55
         */

        LocalDateTime presentDateTime = LocalDateTime.now();
        System.out.println(presentDateTime);
        System.out.println(presentDateTime.getYear());
        System.out.println(presentDateTime.getDayOfWeek());
        System.out.println(presentDateTime.getHour());
        /**
         * 2024-06-18T10:39:15.082501800
         * 2024
         * TUESDAY
         * 10
         */

        // 임의로 특정 시간을 만들어 내고 싶을 때 : of 메소드 사용 => 날짜 직접 받기 (of)
        LocalDate birthDay = LocalDate.of(1998, 6, 3);
        System.out.println(birthDay.getYear());
        System.out.println(birthDay.getMonth());
        System.out.println(birthDay.getDayOfMonth());
        /**
         * 1998
         * JUNE
         * 3
         */

        LocalTime birthTime = LocalTime.of(20, 20, 20);
        System.out.println(birthTime.getSecond());

        LocalDateTime birthDayTime = LocalDateTime.of(1998, 6, 3, 20, 20, 20);
        System.out.println(birthDayTime); //1998-06-03T20:20:20
        // 매개변수로 크로노필드 enum 타입을 사용하여 프로그램의 유연성 향상
        System.out.println(birthDayTime.get(ChronoField.YEAR));
        System.out.println(birthDayTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(birthDayTime.get(ChronoField.DAY_OF_MONTH));
        System.out.println(birthDayTime.get(ChronoField.HOUR_OF_DAY));
        // 0 : 오전, 1 : 오후
        System.out.println(birthDayTime.get(ChronoField.AMPM_OF_DAY));


        System.out.println("===myWatch===");
        myWatch(LocalDateTime.now(), ChronoField.AMPM_OF_DAY); // 오전입니다.
    }


    static void myWatch(LocalDateTime localDateTime, ChronoField c) {
        if (c == ChronoField.YEAR) {
            System.out.println("연도는 " + localDateTime.get(c) + "입니다. "); // 매개변수로 사용하기
        } else if (c == ChronoField.MONTH_OF_YEAR) {
            System.out.println("월은 " + localDateTime.get(c) + "입니다. ");
        } else if (c == ChronoField.AMPM_OF_DAY) {
            if (localDateTime.get(c) == 0) {
                System.out.println("오전입니다.");
            } else {
                System.out.println("오후입니다.");
            }
        }

    }
}
