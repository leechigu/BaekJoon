import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 평범한배낭_dfs_TimeoutFail {

    static boolean[] isVisited;
    static int[][] arr;
    static int n;
    static int k;
    static int max;
    static void dfs(int curIndx,int curWeight, int curVal){

        if(curWeight>k)
            return;

        max = Math.max(max,curVal);

        for(int i=curIndx;i<n;i++){
            int weight = arr[i][0];
            int val = arr[i][1];
            if(weight+curWeight<=k)
                dfs(i+1,weight+curWeight,curVal+val);
            dfs(i+1,curWeight,curVal);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");
        n = Integer.parseInt(splitStr[0]);
        k = Integer.parseInt(splitStr[1]);
        max = -1;
        arr = new int[n][2];
        isVisited = new boolean[n];

        for(int i=0;i<n;i++){
            splitStr = br.readLine().split(" ");
            int a = Integer.parseInt(splitStr[0]);
            int b = Integer.parseInt(splitStr[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }

        dfs(0,0,0);

        System.out.println(max);



    }
}
