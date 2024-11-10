import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스티커 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int t = Integer.parseInt(input);
        for(int i=0;i<t;i++){

            input = br.readLine();

            int n = Integer.parseInt(input);
            int[][] map = new int[2][n];

            input = br.readLine();
            String[] splitStr = input.split(" ");

            for(int j=0;j<n;j++)
                map[0][j] = Integer.parseInt(splitStr[j]);

            input = br.readLine();
            splitStr = input.split(" ");

            for(int j=0;j<n;j++)
                map[1][j] = Integer.parseInt(splitStr[j]);

            int[][] cur = new int[2][n];
            cur[0][0] = map[0][0];
            cur[1][0] = map[1][0];

            if(n==1){
                sb.append(Math.max(cur[0][0],cur[1][0])).append("\n");
                continue;
            }

            cur[0][1] = map[1][0]+map[0][1];
            cur[1][1] = map[0][0]+map[1][1];
            if(n==2){
                sb.append(Math.max(cur[0][1],cur[1][1])).append("\n");
                continue;
            }

            for(int j=2;j<n;j++){
                int zero1 = cur[0][j-2]+map[1][j-1]+map[0][j];
                int one1 = cur[1][j-2]+map[0][j-1]+map[1][j];

                int zero2 = cur[1][j-2] + map[0][j];
                int one2 = cur[0][j-2] + map[1][j];

                int zero3 = cur[1][j-1]+ map[0][j];
                int one3 = cur[0][j-1] + map[1][j];

                cur[0][j] = Math.max(Math.max(zero1,zero2),zero3);
                cur[1][j] = Math.max(Math.max(one1,one2),one3);
            }
            sb.append(Math.max(cur[1][n-1],cur[0][n-1])).append("\n");
        }
        System.out.println(sb);
    }
}
