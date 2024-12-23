import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {

    static boolean[] isVisited;

    static String bfs(int cur, int target) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<String> operations = new LinkedList<>();

        queue.add(new int[]{cur, 0}); // [현재 값, 연산 수]
        operations.add("");

        isVisited[cur] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int val = poll[0];
            String curOps = operations.poll();

            if (val == target) {
                return curOps;
            }

            // D
            int doubleVal = (val * 2) % 10000;
            if (!isVisited[doubleVal]) {
                isVisited[doubleVal] = true;
                queue.add(new int[]{doubleVal, val});
                operations.add(curOps + "D");
            }

            // S
            int minusOneVal = val == 0 ? 9999 : val - 1;
            if (!isVisited[minusOneVal]) {
                isVisited[minusOneVal] = true;
                queue.add(new int[]{minusOneVal, val});
                operations.add(curOps + "S");
            }

            // L
            int lVal = (val % 1000) * 10 + (val / 1000);
            if (!isVisited[lVal]) {
                isVisited[lVal] = true;
                queue.add(new int[]{lVal, val});
                operations.add(curOps + "L");
            }

            // R
            int rVal = (val % 10) * 1000 + (val / 10);
            if (!isVisited[rVal]) {
                isVisited[rVal] = true;
                queue.add(new int[]{rVal, val});
                operations.add(curOps + "R");
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            isVisited = new boolean[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String answer = bfs(a, b);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}