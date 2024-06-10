package C01Basic;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class C08List {

    public static void main(String[] args) {

        // List 선언 방법
        // ArrayList<타입> 변수명 =  new ArrayList<>();
        /*ArrayList<String> myList = new ArrayList<>();

        // 가장 일반적인 list 선언 방법
        // 왼쪽엔 인터페이스, 오른쪽엔 구현체(클래스)
        List<String> myList2 = new ArrayList<>(); // 사용 가능한 기능 list에 제한되어있음

        // 초기값 생성 방법1 - 하나씩 add
        myList2.add("java");
        myList2.add("python");
        myList2.add("c++");

        // 초기값 생성 방법2 - 리스를 주입하는 방식
        String[] myArr = {"java", "python", "c++"};
        List<String> myList3 = new ArrayList<>(myList2); // 리스트를 넣기
        List<String> myList4 = new ArrayList<>(Arrays.asList(myArr)); // 배열을 넣기
        List<String> myList6 = new ArrayList<>(List.of(myArr));

        int[] intArr = {10, 20, 30};
        // int배열은 못들어옴 -> Integer가 들어와야하는데 int가 받아졌기 때문에 >> 해결 for문
        //List<Integer> myList5 = new ArrayList<>(Arrays.asList(intArr));
        List<Integer> myList5 = new ArrayList<>();
        for (int i : intArr) {
            myList5.add(i);
        }*/


        /*List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        System.out.println(myList); // [10, 20] 출력

        // add(index, 값) : 중간에 값 삽입
        myList.add(0, 30);
        System.out.println(myList); // 0번째 인덱스에 30 추가

        List<Integer> myList2 = new ArrayList<>();
        myList2.add(1);
        myList2.add(2);
        System.out.println(myList2);

        // 특정 리스트의 요소를 모두 add
        myList.addAll(myList2);
        System.out.println(myList); // [30, 10, 20, 1, 2]

        // get 요소 반환
        System.out.println(myList.get(0));

        // for문 돌려서 전체 list 출력
        // size() : 리스트의 길이 (개수) 반환
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        for (Integer i : myList) {
            System.out.println(i);
        }

        // remove : 요소 삭제
        // (1) index를 통한 삭제 (2) value를 통한 삭제
        System.out.println("전 : " + myList); // 전 : [30, 10, 20, 1, 2]
        myList.remove(0);
        System.out.println("후 : " + myList); // 후 : [10, 20, 1, 2]
        myList.remove(Integer.valueOf(20));
        System.out.println("더 후 : " + myList); // 더 후 : [10, 1, 2]

        // set(index, value) : 인덱스 위치의 자리에 value값 세팅 (변경)
        System.out.println(myList); // [10, 1, 2]
        myList.set(0, 55);
        System.out.println(myList); // [55, 1, 2]

        // indexOf : 특정 값이 몇번째 index에 위치한지 return
        // 가장 먼저 나오는 값의 index return
        System.out.println("몇번째게 : " + myList.indexOf(55)); // 몇번째게 : 0
    */

        // 전체 삭제 : clear()

        // isEmpty : 값이 비었는지 안비었는지

        // contains : 특정 값이 있는지 없는지 확인
        /*List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.contains(10)); // true (있냐없냐?)

        // 이중리스트 (리스트 안에 리스트)
        List<List<Integer>> newList = new ArrayList<>();
        // [[], [], [] , ..] -> 초기화가 안되어있음
        newList.add(new ArrayList<>()); // 안에 이렇게 추가해야 함 ⭐
        newList.add(new ArrayList<>());
        newList.get(0).add(0);
        newList.get(0).add(1);
        newList.get(1).add(34);
        System.out.println(newList); // [[0, 1], [34]] -> 이중리스트


        // 리스트 안에 배열
        List<int[]> newList2 = new ArrayList<>();
        newList2.add(new int[]{1, 2});
        newList2.add(new int[]{10, 20, 30});
        newList2.add(new int[]{100, 200, 300, 400});
        System.out.println(Arrays.toString(newList2.get(0)));*/

        // 리스트의 정렬 : Collections.sort(), 리스트 객체.sort()
        /*List<Integer> myList = new ArrayList<>();
        myList.add(5);
        myList.add(3);
        myList.add(2);
        myList.add(1);
        myList.add(4);

        // 1. Collections.sort() => arrayList안에 내장되어 있는 애
        Collections.sort(myList); // 기본 - 오름차순
        System.out.println("오름차순 " + myList);
        Collections.sort(myList, Comparator.reverseOrder()); // 내림차순
        System.out.println("내림차순 " + myList);

        // 2. 리스트객체.sort()
        myList.sort(Comparator.naturalOrder()); // 오름차순
        System.out.println("오름차순 " + myList);
        myList.sort(Comparator.reverseOrder()); // 내림차순
        System.out.println("내림차순 " + myList);*/

        // 배열과 list간의 변환 -> 웬만해선 for문 사용
        // 1. String 배열을 List<String>로 변환
        String[] stArr = {"java", "python", "c++"};
        // 1-(1)
        List<String> stList = new ArrayList<>(Arrays.asList(stArr)); // 배열넣어서 선언과 초기화
        // 1-(2) for문을 통해 담기 -> 이거 사용
        // 1-(3) streamApi (참고만)
        List<String> stList2 = Arrays.stream(stArr).collect(Collectors.toList());

        // 2. List<String> -> String으로 변환
        // 2-(1) for문으로 ㄱㄱ
        // 2-(2) toArray 사용
        String[] stArr2 = stList.toArray(new String[stList.size()]);

        // 3. int 배열을 -> List<Integer>로 변환
        // 3-(1) for문
        // 3-(2) streamApi 사용
        int[] intArr = {10, 20, 30, 40};
        List<Integer> intList = Arrays.stream(intArr)
                                    .boxed()
                                    .collect(Collectors.toList());

    }
}
