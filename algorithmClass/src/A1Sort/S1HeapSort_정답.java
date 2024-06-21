package A1Sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class S1HeapSort_정답 {

    public static void main(String[] args) {

        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        // 최초 힙구성
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
        System.out.println("최초 힙 : " + Arrays.toString(arr));
        // 루트노드와 최하위 노드 change하면서 heapify
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i-1, 0);
        }
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        Queue<Integer> pq = new PriorityQueue<>();

        for (int a: arr2) {
            pq.add(a);
        }
        System.out.println("pq : " + pq); // pq : [1, 3, 5, 5, 7, 6, 9, 8, 6] => 정렬은 안됐지만 heap구조
        // pq는 add 할 때부터 heap구조가 완성됨
        // pq는 add할 때 상향식 heapify, poll할 땐 하향식 heapify

    }

    static void heapify(int[] arr, int arrlength, int node) {

        // 왼쪽 노드 : node * 2 + 1
        // 오른쪽 노드 : node * 2 + 1

        int left = node * 2 + 1;
        int right = node * 2 + 2;

        if (left  > arrlength) return;
        if (right > arrlength) {
            // 노드랑 left만 비교
            if (arr[node] > arr[left]) {
                int tmp = arr[node];
                arr[node] = arr[left];
                arr[left] = tmp;

                heapify(arr, arrlength, left);
            }
        } else {
            // node, left, right 모두 비교
            int index = 0;
            if (arr[node] > arr[left] || arr[node] > arr[right]) {
                if (arr[left] > arr[right]) {
                    index = right;
                } else {
                    index = left;
                }
                int tmp = arr[node];
                arr[node] = arr[index];
                arr[index] = tmp;

                heapify(arr, arrlength, index);
            }
        }
    }

}
