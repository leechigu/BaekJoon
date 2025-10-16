import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 카드게임 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        int[] arr = new int[m + 1];
        boolean[] isPossible = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            isPossible[arr[i]] = true;
        }

        Arrays.sort(arr);

        int indx = 1;
        int cur = arr[indx];

        for (int i = 1; i <= n; i++) {
            if (i >= cur) {
                //System.out.println(i + " - " + cur);
                indx++;
                if (indx == arr.length)
                    break;
                cur = arr[indx];
            }
            parent[i] = cur;
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(st.nextToken());
            int head = parent[x];

            while (true) {
                if (isPossible[head]) {
                    break;
                } else {
                    parent[x] = parent[head];
                    head = parent[x];
                }
            }

            sb.append(head).append("\n");
            isPossible[head] = false;
        }

        System.out.print(sb.toString());
    }
}