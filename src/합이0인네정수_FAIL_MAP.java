import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 합이0인네정수_FAIL_MAP {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][4];

        StringTokenizer st = null;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                map1.put(arr[i][0] + arr[j][1], map1.getOrDefault(arr[i][0] + arr[j][1], 0) + 1);
            }
        }
        int answer=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = arr[i][2] + arr[j][3];
                answer += map1.getOrDefault(-sum, 0);
            }
        }

        System.out.print(answer);
    }
}
