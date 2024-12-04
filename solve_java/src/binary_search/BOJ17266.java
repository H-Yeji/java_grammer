package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17266 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] location = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            location[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1;
        int high = n;
        int result = 0;

        while(low <= high){
            int mid = (low + high) / 2;

            int temp = 0;
            for (int loc: location){
                if (loc - mid > temp){
                    low = mid + 1;
                    break;
                }
                temp = loc + mid;
            }

            if (temp < n){
                low = mid + 1;
                continue;
            }

            result = mid;
            high = mid - 1;
        }

        System.out.println(result);
    }
}
