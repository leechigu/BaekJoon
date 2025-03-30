import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다각형의면적 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.printf("%.1f\n", getPolygonArea(arr));
    }

    public static double getPolygonArea(int[][] arr) {
        int n = arr.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int x1 = arr[i][0];
            int y1 = arr[i][1];
            int x2 = arr[(i + 1) % n][0];
            int y2 = arr[(i + 1) % n][1];

            sum += (long)x1 * y2 - (long)x2 * y1;
        }

        return Math.abs(sum) / 2.0;
    }
}
