import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱셈 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++)
                arr1[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[m][k];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<k;j++)
                arr2[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] answer = new int[n][k];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                int val = 0;
                for (int x = 0; x < m; x++) {
                    val += arr1[i][x] * arr2[x][j];
                }
                answer[i][j] = val;
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
