import java.util.Scanner;

public class baekjoon15650_2 {

    static int[] arr;
    static int n,m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        arr = new int[m];
        dfs(1,0);


    }

    public static void dfs(int at,int depth){
        if(depth ==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=at;i<=n;i++){
            arr[depth]=i;
            dfs(i+1,depth+1);
        }
    }
}