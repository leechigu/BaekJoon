import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선분교차2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        // 기울기 check
        double n1 = (y2 - y1) / (double)(x2 - x1);
        double n2 = (y4 - y3) / (double)(x4 - x3);

        double m1 = y1 - n1 * x1;
        double m2 = y3 - n2 * x3;

        if (n1 == n2) {
            if (m1 == m2) {
                if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.max(x1, x2) >= Math.min(x3, x4)) {
                    System.out.println(1);
                    return;
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                System.out.println(0);
                return;
            }
        }

        // 교차하는 점의 범위가 선분 내에 있는지 체크
        double x = (m2 - m1) / (n1 - n2);

        System.out.println((int)x);

        // System.out.println(x);

        if (Math.min(x1, x2) <= x && Math.max(x1, x2) >= x) {
            if (Math.min(x3, x4) <= x && Math.max(x3, x4) >= x) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}