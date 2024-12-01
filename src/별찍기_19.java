import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 별찍기_19 {

    static  char[][] map;
    static int n;
    public static void recursive(int cur){
        if(cur==0){
            return;
        }

        int start = (n - cur) * 2;
        int end = (n - 1) * 4  - start;

        for(int i=start;i<=end;i++){
            map[start][i] = '*';
            map[end][i] = '*';
            map[i][start] = '*';
            map[i][end] = '*';
        }

        recursive(cur-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int len  = 4 * (n - 1) + 1;
        map = new char[len+1][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                map[i][j] = ' ';
            }
        }

        recursive(n);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            String a = new String(map[i]);
            sb.append(a).append("\n");
        }

        System.out.println(sb);

    }
}
