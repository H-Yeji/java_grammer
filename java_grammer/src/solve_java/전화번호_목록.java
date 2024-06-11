package solve_java;

import java.util.*;

public class 전화번호_목록 {

    public static boolean solution(String[] phone_book) {


        // 배열로 풀기
        Arrays.sort(phone_book); // 119 1195522.. , 97.. => 일단 시작과 동시에 정렬하니까 i-1과만 비교해도 충분함
        for (int i = 1 ; i < phone_book.length ; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) return false; // startWith : -로 시작하는지 확인
        }
        return true;

        // 시간초과
        /*List<String> list = new ArrayList<String>();
        for (String s : phone_book) {
            list.add(s);
        }
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).length() < list.get(j).length()) {
                    if (list.get(i).charAt(0) == list.get(j).charAt(0) && list.get(j).contains(list.get(i))) {
                        return false;
                    }
                } else if (list.get(i).length() > list.get(j).length()) {
                    if (list.get(i).charAt(0) == list.get(j).charAt(0) && list.get(i).contains(list.get(j))) {
                        return false;
                    }
                }
            }
        }
        return true;*/
    }

    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
}
