package C05AnonymousLambda;

import java.util.*;

public class C03ComparableComparator {

    public static void main(String[] args) {
        // 자바에서는 비교를 위한 인터페이스 2개 제공 : Comparable, Comparator
        // Comparable 인터페이스에는 compareTo 메서드 선언
        // Comparator 인터페이스에는 Compare 메서드 선언

        // String 클래스에 compareTo 내장 (Comparable 구현)
        // String 클래스 외에 java 많은 내장 클래스에서 Comparable 구현
        /*String a = "hello";
        String b = "horld"; // 오타
        // 두 문자열의 각 자라리를 순차적으로 비교
        // 문자열의 비교는 유니코드 값의 차이를 반환
        System.out.println(a.compareTo(b)); // -10

        // int는 안되고 Integer로 사용해야 함
        Integer a1 = 10;
        Integer a2 = 10;
        System.out.println(a1.compareTo(a2)); // 0 같음


        List<String> myList = new ArrayList<String>();
        myList.add("java");
        myList.add("python");
        myList.add("javascript");
        Collections.sort(myList, Comparator.reverseOrder());
        System.out.println(myList); // [python, javascript, java]
        Collections.sort(myList, Comparator.naturalOrder());
        System.out.println(myList); // [java, javascript, python]
        // Comparable의 compareTo 메서드를 구현하여 정렬

        myList.sort(Comparator.naturalOrder());
        myList.sort(Comparator.reverseOrder());*/


        List<Student> students = new ArrayList<>();
        students.add(new Student("yeji", 27));
        students.add(new Student("dding2", 25));
        students.add(new Student("arorong", 29));
        students.add(new Student("eunji", 24));
        students.add(new Student("suguri", 27));

        // (1) Student객체에서 Comparable을 구현 => compareTo 메서드를 오버라이딩
        /*Collections.sort(students);
        //students.sort(Comparator.reverseOrder());
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAge());
        }*/

        // (2) Comparator를 구현한 익명 객체를 sort에 주입
        /*Comparator<Student> myComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //return o1.getAge() - o2.getAge(); // 오름차순
                // return o2.getAge() - o1.getAge(); // 내림차순
                return o1.getName().compareTo(o2.getName()); // 이름으로 오름차순
            }
        };*/
        Comparator<Student> myComparator = (a, b) -> a.getName().compareTo(b.getName());
        students.sort(myComparator);
        /*for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAge());
        }*/
        // toString 추가했음 -> for문 없이 그냥 출력 가능
        System.out.println(students);
        // [이름 : arorong, 나이 : 29, 이름 : dding2, 나이 : 25, 이름 : eunji, 나이 : 24, 이름 : suguri, 나이 : 27, 이름 : yeji, 나이 : 27]


        // 실습
        // 아래 문자열을 글자길이 순으로 내림차순 정렬해라
        String[] stArr = {"hello", "java", "c++", "world2"};
        // 정렬할 때 : Arrays.sort(stArr, Comparator.reverseOrder());
        Comparator<String> myComparator2 = (a, b) -> a.length() - b.length(); // [c++, java, hello, world2]
        Arrays.sort(stArr, myComparator2);
        System.out.println(Arrays.toString(stArr));

        // 실습2
        // [[4, 5], [1, 2], [3, 1], [5, 1]]
        // 위 배열이 들어간 아래 리스트를 배열에 0번째가 아닌 1번째를 기준으로 내림차순 정렬
        List<int[]> myList = new ArrayList<>();
        myList.add(new int[]{4, 5});
        myList.add(new int[]{1, 2});
        myList.add(new int[]{3, 1});
        myList.add(new int[]{5, 1});
        //System.out.println(Arrays.toString(myList.get(0)));

        Comparator<int[]> myComparator3 = (a, b) -> b[1] - a[1];
        myList.sort(myComparator3);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(Arrays.toString(myList.get(i)));
        }

        System.out.println("==========================");
        // 만약 1번째가 같으면 0번째로 내림차순
        Comparator<int[]> myComparator4 = (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        };
        myList.sort(myComparator4);
        for (int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }


        // 6/17
        System.out.println("=============pq 정렬================");
        String[] stArr2 = {"hello", "java", "c++", "world2"};

        //Queue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Queue<String> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 둘 다 가능 => 내림차순
        Queue<String> pq = new PriorityQueue<>((a, b) -> a.length() - b.length()); // 길이 순서대로 오름차순
        // -> priorirtqueue는 정렬되어 poll되기 때문엔 내부에 comparator를 가지고 있어서 바로 람다식 사용 가능
        // -> TreeMap도 내부에 comparator 가지고 있음 !
        for (String s : stArr2) {
            pq.add(s);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // runable 인터페이스 : 스레드 구현
        // 스레드 구현 방법 : 스레드 상속, runnable 주입
        // runnable 인터페이스 주입을 통한 스레드 생성
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("새로 생성한 스레드1 입니다.");
            }
        });
        t1.start();
        // 람다식 가능
        Thread t2 = new Thread(() -> {
            System.out.println("새로 생성한 스레드2 입니다.");
        });
        t2.start();

        new Thread(() -> System.out.println("새로 생성한 스레드3 입니다.")).start();
        System.out.println("main 스레드 입니다."); //기본적으로 스레드 1개가 있음

    }
}


//class Student implements Comparable<Student>{ // 어떤 객체와 비교할건지 Comparable<Student> 써줘야함
class Student implements Comparator<Student> { // 어떤 객체와 비교할건지 Comparable<Student> 써줘야함

    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    /*@Override
        public int compareTo(Student s) { // ⭐
            // return this.age - s.getAge(); // 오름차순
            // return s.getAage() - this.age; // 내림차순 (반대일 경우)

            // return s.getName().compareTo(this.name); // 이름(문자열)으로 내림차순 정렬
            return this.name.compareTo(s.getName()); // 이름(문자열)으로 오름차순 정렬 ⭐
    }*/

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }

    // 모든 클래스의 조상 클래스인 Object 클래스의 toString 메서드를 Overriding하여
    // 객체 호출 시에 자동으로 toString 메서드 호출
    @Override
    public String toString() { // 메서드명 반드시 toString

        return "이름 : " + this.name + ", 나이 : " + this.age;
    }

}
