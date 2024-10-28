import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이만들기 {


    public static int[] check(int[][] map, boolean[][] isVisited, int x1,int x2,int y1,int y2){
        int curVal = map[y1][x1];

        for(int i=y1;i<y2;i++){
            for(int j=x1;j<x2;j++){
                if(isVisited[i][j])
                    return new int[]{-1,-1};
                if(map[i][j]!=curVal){
                    return new int[]{-1,-1};
                }
            }
        }

        for(int i=y1;i<y2;i++)
            for(int j=x1;j<x2;j++)
                isVisited[i][j] = true;
        return new int[]{curVal,1};
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);

        int[][] arr = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];

        for(int i=0;i<n;i++){
            input = br.readLine();
            String[] splitStr = input.split(" ");
            for(int j=0;j<n;j++){
                int x = Integer.parseInt(splitStr[j]);
                arr[i][j] = x;
            }
        }

        int cur = n;
        int blue = 0;
        int white = 0;

        while(true){
            if(cur==0){
                break;
            }
            int quot = n/cur;
            for(int i=0;i<n;i+=cur){
                for(int j=0;j<n;j+=cur){
                    int[] rtn = check(arr, isVisited, j, j + cur, i, i + cur);
                    if(rtn[1]==1){
                        if(rtn[0]==1)
                            blue++;
                        else if(rtn[0]==0)
                            white++;
                    }
                }
            }
            cur/=2;
        }

        System.out.println(white);
        System.out.println(blue);

    }
}
