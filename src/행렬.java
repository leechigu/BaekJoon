import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];


        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                a[i][j] = input.charAt(j)-'0';
            }
        }

        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                b[i][j] = input.charAt(j)-'0';
            }
        }

        int answer =0;

        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                int x = a[i][j];
                int y = b[i][j];
                if(x!=y){
                    answer++;
                    for(int tempI = i;tempI<i+3;tempI++){

                        for(int tempJ = j;tempJ<j+3;tempJ++){
                            //System.out.print(a[tempI][tempJ]+" ");
                            if(a[tempI][tempJ]==1){
                                a[tempI][tempJ] = 0;
                            }
                            else{
                                a[tempI][tempJ] = 1;
                            }
                        }
                        //System.out.println();
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]!=b[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);

    }
}
