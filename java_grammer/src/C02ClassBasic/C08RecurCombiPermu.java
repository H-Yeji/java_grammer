package C02ClassBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// recursive combination permutation(?) 조합과 순열
public class C08RecurCombiPermu {

    public static void main(String[] args) {

        /*List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<List<Integer>> combination = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>(); // 행마다 생성
        // myList로 만들 수 있는 2개짜리 숫자 조합을 이중리스트에 담기
        System.out.println(Arrays.toString(myList.toArray()));

        for (int i = 0; i < myList.size() - 1; i++) {
            tmp.add(myList.get(i));
            for (int j = i + 1; j < myList.size(); j++) {
                tmp.add(myList.get(j));
                combination.add(tmp);
                System.out.println("tmp : " + Arrays.toString(tmp.toArray()));
                System.out.println("combination : " + Arrays.toString(combination.toArray()));
                tmp.remove(tmp.size() - 1); // index로 끝자리 잘라내기
                System.out.println("tmp : " + Arrays.toString(tmp.toArray()));
                System.out.println("combination : " + Arrays.toString(combination.toArray()));
            }
            tmp.remove(tmp.size() - 1);
        }*/

        /*List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<myList.size()-1; i++){
            temp.add(myList.get(i));
            for(int j=i+1; j<myList.size(); j++){
                temp.add(myList.get(j));
                combinations.add(temp);
                System.out.println("combinations: " + Arrays.toString(combinations.toArray()));
                temp.remove(temp.size()-1);
            }
            temp.remove(temp.size()-1);
            System.out.println("for문 내의 combination" + Arrays.toString(combinations.toArray()));
        }
        System.out.println(Arrays.toString(combinations.toArray()));*/

        /*List<Integer> myList = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<List<Integer>> answer = new ArrayList<>();
        combination(answer, new ArrayList<>(), myList,  2, 0);
        System.out.println(answer);*/

        List<Integer> myList = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<List<Integer>> answer = new ArrayList<>();
        permutation(answer, new ArrayList<>(), myList,  2, new boolean[myList.size()]);
        //permutation(answer, new ArrayList<>(), myList, 2, 0);
        System.out.println(answer);
    }

    static void combination(List<List<Integer>> answer, List<Integer> tmp, List<Integer> myList, int count, int start) {

        // 종료 로직
        if (tmp.size() == count) {
            // tmp값을 그대로 add할 경우 tmp메모리 값이 add되므로, 모든 answer 리스트에 같은 tmp리스트 add
            answer.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < myList.size(); i++) {
            tmp.add(myList.get(i));
            System.out.println("tmp : " + Arrays.toString(tmp.toArray()));
            combination(answer, tmp, myList, count, i + 1);

            System.out.println("combination : " + Arrays.toString(answer.toArray()));
            tmp.remove(tmp.size() - 1);
            System.out.println("remove 후 tmp : " + Arrays.toString(tmp.toArray()));
        }
    }
    static void permutation(List<List<Integer>> answer, List<Integer> tmp, List<Integer> myList, int count, boolean []visited) {

        // 종료 로직
        if (tmp.size() == count) {
            // tmp값을 그대로 add할 경우 tmp메모리 값이 add되므로, 모든 answer 리스트에 같은 tmp리스트 add
            answer.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < myList.size(); i++) {
            if (visited[i] == false) {
                tmp.add(myList.get(i));
                permutation(answer, tmp, myList, count, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
   /*static void perm(List<List<Integer>> answer, List<Integer> temp, List<Integer> myList, int count, boolean []visited){
       if(temp.size() == count){
           answer.add(new ArrayList<>(temp));
           return;
       }
       for(int i=0; i<myList.size(); i++){
           if(visited[i]==false){
               visited[i] = true;
               temp.add(myList.get(i));
               perm(answer, temp, myList, count, visited);
               temp.remove(temp.size()-1);
               visited[i] = false;
           }
       }
   }*/
}
