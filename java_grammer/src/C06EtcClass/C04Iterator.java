package C06EtcClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C04Iterator {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        // enhanced for문 : 원본 변경 불가
        /*for (String a : myList) {
            System.out.println(a);
        }*/

        // iterator는 참조하고 있는 원본 데이터 삭제 가능 -> remove
        Iterator<String> iters = myList.iterator();
        while (iters.hasNext()) {
            // iterator의 hasnext로 소모하면서 꺼낸다
            System.out.println(iters.next());
        }

        Iterator<String> iters2 = myList.iterator();
        while (iters2.hasNext()) {

            if (iters2.next().equals("banana")) { // 돌면서 banana가 나오면
                iters2.remove(); // 지우기
            }
        }
        System.out.println(myList);
    }
}
