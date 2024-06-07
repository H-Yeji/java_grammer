package C01Basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class C07Array {

    public static void main(String[] args) {

        /*// 배열 표현식1 : literal 방식
        int[] arr1 = {1, 2, 3, 4, 5};

        // 배열 표현식2 : 선언 후 할당방식
        int[] arr2 = new int[5];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        arr2[3] = 4;
        // 값을 넣지 않았지만 자동 0으로 초기화돼서 0출력됨
        System.out.println(arr2[4]);

        char[] charArr = new char[10];
        System.out.println(charArr[0]);

        String[] stringArr = new String[10]; // null 초기화
        System.out.println(stringArr[0]);

        // 표현식3 -> 잘 안씀
        int[] arr3 = new int[]{1, 2, 3, 4};

        // 표현식4 -> 불가
        //int[] arr4 = new int[]; // 사전에 길이가 지정되지 않으면 안됨 */

        /*String[] stArr = new String[5];
        stArr[0] = "hello";
        stArr[1] = "java";
        // null pointer exception -> 2번째에 null이 들어가있기 때문에 예외 터짐
        //System.out.println(stArr[2].length());

        String[] stArr2 = new String[5];
        // 배열에 한꺼번에 값 세팅
        Arrays.fill(stArr2, "java");
        for(String str : stArr2) {
            System.out.println(str);
        }
        for (int i = 0; i < stArr2.length; i++) {
            System.out.println(stArr2[i]);
        }*/

        // 85, 65, 90인 배열 선언하고, 총합, 평균을 구해랏
        /*int[] scores = {85, 65, 90};
        int sum = 0;
        for (int score:scores) {
            sum += score;
        }
        System.out.println(sum);
        System.out.println(sum/scores.length);*/


        // 최대값, 최소값
        /*int[] arrs = {10, 20, 30, 12, 8, 17};
        int max = arrs[0]; // Integer.MIN_VALUE
        int min = arrs[0]; // Integer.MAX_VALUE
        for (int arr: arrs) {
            if (max < arr)
                max = arr;
            if (min > arr)
                min = arr;
        }
        System.out.println(max);
        System.out.println(min);*/

        // 배열의 순서바꾸기
        /*int[] arr = {10, 20};
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;

        int[] arr2 = {10, 20, 30, 40, 50};
        for (int i = 0; i < arr2.length - 1; i++) {
            tmp = arr2[i];
            arr2[i] = arr2[i + 1];
            arr2[i + 1] = tmp;
        }
        System.out.println(Arrays.toString(arr2));*/

        // 배열 뒤집기
        /*int[] arr = {1, 2, 3, 4, 5};
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[arr.length - i - 1] = arr[i];
        }
        System.out.println(Arrays.toString(result));*/

        // 숫자 뒤집기
        // 문자 배열로 만들고 문자열로 합해서 문자열로 출력
        /*int num = 1234;

        String stNum = Integer.toString(num);
        char[] ch = stNum.toCharArray();

        String answer = "";
        for (int i = ch.length - 1; i >= 0 ; i--) {
            answer += ch[i];
        }
        System.out.println(answer);*/

        // StringBuilder로 작성하기
        /*int num = 1234;

        String stNum = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        int cnt = stNum.length() - 1;
        for (int i = 0; i < stNum.length(); i++) {
            sb.append(stNum.charAt(cnt - i));
        }
        String answer = sb.toString();
        System.out.println(answer);*/
        // String resuilt = sb.reverse().toString(); 간결 그자체


        // 정렬
        /*int[] arr = {5, 1, 2, 7, 3, 1, 2};
        Arrays.sort(arr); // 오름차순 정렬 (기본)
        System.out.println(Arrays.toString(arr));

        // 문자 정렬
        String[] fruits = {"banana", "apple", "cherry", "Apple"};
        Arrays.sort(fruits); // 아스키코드 기준으로 정렬
        System.out.println(Arrays.toString(fruits)); // [Apple, apple, banana, cherry]

        String[] fruits2 = {"apple1", "apple11", "apple2"};
        Arrays.sort(fruits2);
        System.out.println(Arrays.toString(fruits2)); // [apple1, apple11, apple2]

        // 내림차순
        String[] stArr = {"hello", "hi", "bye", "goodmorning"};
        Arrays.sort(stArr, Comparator.reverseOrder()); // 내림차순
        System.out.println(Arrays.toString(stArr)); // [hi, hello, goodmorning, bye]
        */

        // 위 내림차순 방법에 문제가 있음
        // => 기본형 타입은 Comparator로 처리 불가 (숫자 안됨 왜지..?)
        int[] intArr = {5, 1, 2, 7, 3, 1, 2};
        // Arrays.sort(intArr, Comparator.reverseOrder()); // 빨간색불 뜸
        // 이유 : Comparator이 클래스와 객체만 받을 수 있도록 설정이 되어있음

        // 방볍 (1) -> 오름차순 정렬 후 배열 뒤집기
        // 방법 (2) -> streamapi, lambda를 활용한 내림차순 정렬
        // intArr 대상으로 stream객체 생성
        int[] answer = Arrays.stream(intArr)
                .boxed() // int요소를 Integer로 형변환 시키는 메서드
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .mapToInt(a->a) // Integer를 다시 int로 형변환 (위에서 boxed를 했으니)
                .toArray(); // stream을 배열로 변환

        System.out.println(Arrays.toString(answer)); // [7, 5, 3, 2, 2, 1, 1]



    }
}
