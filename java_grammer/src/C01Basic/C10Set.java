package C01Basic;

import java.util.*;

public class C10Set {

    public static void main(String[] args) {

        /*Set<String> mySet = new HashSet<>();
        mySet.add("h");
        mySet.add("h");
        mySet.add("e");
        mySet.add("l");
        mySet.add("l");
        mySet.add("o");
        System.out.println(mySet); // 중복 제거되고 순서 없이 출력됨*/


        /*List<String> myList = new ArrayList<>();
        myList.add("tennis");
        myList.add("baseball");
        myList.add("baseball");
        myList.add("basketball");
        myList.add("basketball");

        // list를 인자값으로 받아서 초기값 세팅 가능
        Set<String> mySet = new HashSet<>(myList);
        System.out.println(mySet); // [basketball, baseball, tennis]

        // 배열을 인자값으로 받아서 list변경 후 넣기 -> Arrays.asList(arr)
        String[] arr = {"baseball", "baseball", "basketball", "basketball"};
        Set<String> mySet2 = new HashSet<>(Arrays.asList(arr));
        System.out.println(mySet2); // [basketball, baseball]

        mySet2.remove("baseball");
        System.out.println(mySet2); // [basketball]*/

        // 집합 관련 함수 : 교집합(retainAll), 합집합(addAll), 차집합(removeAll)
        Set<String> set1 = new HashSet<>(Arrays.asList("java", "python", "javascript"));
        Set<String> set2 = new HashSet<>(Arrays.asList("java", "html", "css"));

        // 교집합
        //set1.retainAll(set2);
        //System.out.println(set1); // java 출력 (교집합) -> set1 자기자신이 변경됨

        // 합집합
        //set1.addAll(set2);
        //System.out.println(set1); // [python, css, java, html, javascript]

        // 차집합
        //set1.remove(set2);
        //System.out.println(set1); // [python, java, javascript]

        // LinkedHashSet, TreeSet
        Set<String> mySet = new TreeSet<>();
        mySet.add("h");
        mySet.add("h");
        mySet.add("a");
        mySet.add("b");
        mySet.add("h");
        System.out.println(mySet); // [a, b, h] 중복제거, 자동 정렬 (treeset)

        // 두 개 뽑아서 더하기 treemap으로 풀어보기



    }
}
