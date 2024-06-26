package A4Greedy;

public class G1Basic {


    public static void main(String[] args) {
        // 1, 5, 10, 20 조합해서 99를 만들 수 있는 조합 중 가장 짧은 조합의 길이
        // => 위 경우 그리디 사용 가능 (최고값20이 나머지 숫자들의 배수로 이루어져있기 때문에 20부터 사용하면서 가능)
        // 만약 1, 4, 5로 13을 만든다면 => 그리디를 사용할 수 없음 (dp로 구해아함)
        int[] arr = {1, 5, 10, 20};

    }
}
