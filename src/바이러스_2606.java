import java.util.*;

public class 바이러스_2606 {

    static int arr[][];
    static boolean[] isVisited;
    static int count;

    public static void dfs(int v){
        isVisited[v] =true;

        if(v==arr.length)
            return;
        for(int i=1;i<arr.length;i++){
            if(1 == arr[v][i] &&isVisited[i]==false){
                count++;
                dfs(i);
            }

        }



    }

    public static void main(String[] args) {
        count  =0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int line =sc.nextInt();
        isVisited = new boolean[num+1];
        arr = new int[num+1][num+1];
        int x,y;
        for(int i=0;i<line;i++){
            x= sc.nextInt();
            y = sc.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        dfs(1);
        System.out.print(count);
    }

}
