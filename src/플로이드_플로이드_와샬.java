import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드_플로이드_와샬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] floyd = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(floyd[i],-1);
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(floyd[a][b]==-1)
                floyd[a][b] = c;
            else
                floyd[a][b] = Math.min(floyd[a][b],c);
        }



        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(j==k)
                        continue;
                    if(floyd[j][k]==-1){
                        if(floyd[j][i]==-1||floyd[i][k]==-1)
                            continue;
                        floyd[j][k] = floyd[j][i]+floyd[i][k];
                    }else{
                        if(floyd[j][i]==-1||floyd[i][k]==-1)
                            continue;
                        floyd[j][k] = Math.min(floyd[j][k],floyd[j][i]+floyd[i][k]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(floyd[i][j]==-1)
                    sb.append(0).append(" ");
                else
                    sb.append(floyd[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
