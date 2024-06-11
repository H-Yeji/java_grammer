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
        //int[] intArr = {5, 1, 2, 7, 3, 1, 2};
        // Arrays.sort(intArr, Comparator.reverseOrder()); // 빨간색불 뜸
        // 이유 : Comparator이 클래스와 객체만 받을 수 있도록 설정이 되어있음

        // 방볍 (1) -> 오름차순 정렬 후 배열 뒤집기
        // 방법 (2) -> streamapi, lambda를 활용한 내림차순 정렬
        // intArr 대상으로 stream객체 생성
        /*int[] answer = Arrays.stream(intArr)
                .boxed() // int요소를 Integer로 형변환 시키는 메서드
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .mapToInt(a->a) // Integer를 다시 int로 형변환 (위에서 boxed를 했으니)
                .toArray(); // stream을 배열로 변환

        System.out.println(Arrays.toString(answer)); // [7, 5, 3, 2, 2, 1, 1]
*/

        // 6/10
        // 선택정렬 알고리즘
        /*int[] arr = {17, 20, 19, 25, 12};
        for (int i = 0; i < arr.length - 1; i++) {
            int minNum = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minNum) {
                    minNum = arr[j];
                    minIndex = j;
                }
            }
            // 자리바꾸기
            if (arr[minIndex] < arr[i]) {
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println("result : " +  Arrays.toString(arr));*/

        // 실습 - 숫자 조합의 합
        // 모두 다른 숫자의 배열이 있을 때, 만들어질 수 있는 2개의 조합의 합 출력
        /*int[] intArr = {10, 20, 30, 40, 50, 60};
        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                System.out.printf("%d + %d = %d\n", intArr[i], intArr[j], intArr[i] + intArr[j]);
            }
        }*/

        // 배열의 복사
        // copyOf(배열, length), copyOfRange(배열, start, end)
        /*int[] arr = {10, 20, 30, 40, 50};
        // 길이 10개 -> 나머지는 0으로 채움
        int[] newArr = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(newArr));
        // index=1 포함 index<4
        int[] newArr2 = Arrays.copyOfRange(arr, 1, 4);
        System.out.println(Arrays.toString(newArr2));*/

        // 배열의 중복제거
        /*int[] tmp = {10, 10, 5, 7, 40, 40, 10, 10};
        int[] tmp2 = new int[10];
        Arrays.sort(tmp);
        System.out.println("tmp : " + Arrays.toString(tmp));
        int cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (i != 0 && tmp[i - 1] == tmp[i]) continue;

            tmp2[cnt] = tmp[i];
            cnt++;
        }
        System.out.println("tmp2 : " + Arrays.toString(tmp2));
        int[] tmp3 = Arrays.copyOfRange(tmp2, 0, cnt);
        System.out.println("tmp3 : " + Arrays.toString(tmp3));*/

        // 배열의 검색
        /*int[] arr = {5, 3, 1, 8, 7};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 8) {
                System.out.println(i);
                break;
            }
        }*/

        // 이진검색 (binary search) = 이분탐색
        // 복잡도 O(logn)
        /*int[] arr = {1, 3, 6, 8, 9, 11, 15};
        // 사전에 오름차순 정렬이 되어 있어야 이진검색 가능
        System.out.println(Arrays.binarySearch(arr, 15)); // 15의 index*/

        // 배열간 비교
        /*int[] arr1 = {10, 20, 30};
        int[] arr2 = {10, 20, 30};
        System.out.println(arr1 == arr2); // false -> 배열도 객체임 (다른 메모리 주소)
        // Arrays.equals : 값과 순서가지 동일해야 true
        System.out.println(Arrays.equals(arr1, arr2)); // true*/

        // 다차원 배열
        // 2차원 배열 선언과 할당
        /*int[][] arr = new int[2][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        int[][] arr2 = new int[2][]; // 가변배열
        arr2[0] = new int[3];
        arr2[1] = new int[4];

        int[][] arr3 = {{1,2,3}, {1,2,3}}; // 가변 리터럴 배열*/
        // 실습) [3][4] 사이즈 배열을 선안한 뒤
        // 1~12까지 숫자값 각 배열에 할당 후 출력 - for문 이용
        // {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        /*int[][] arr5 = new int[3][4];
        int cnt = 1;
        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5[i].length; j++) {
                arr5[i][j] = cnt;
                cnt++;
            }
        }
        System.out.println(Arrays.deepToString(arr5));*/

        // 가변 배열 실습 : 행의 길이 (전체 배열의 길이) 5
        // => {{10}, {20, 20}, {30, 30, 30}}, ... }
        int[][] arr6 = new int[5][];
        int start = 10;
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = new int[i + 1]; // 위에서 열의 크기 정의하지 않음 -> 안에서 선언해주기⭐
            Arrays.fill(arr6[i], start);
            start += 10;
        }
        System.out.println(Arrays.deepToString(arr6));


        /*int[][] arr4 = {{10, 20},{10,20,30},{10,20,30,40}};
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(arr2)); // null로 채워짐
        System.out.println(Arrays.deepToString(arr3));
        System.out.println(Arrays.deepToString(arr4));*/




    }
}
