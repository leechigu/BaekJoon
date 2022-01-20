import java.util.Scanner;

public class baekjoon15652 {

    static boolean[][] arr;
    static int n,m;

    static void perm(int num){
        if(num==m){
            setnum();
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!arr[i][j]){
                    arr[i][j] =true;
                    perm(num+1);
                    arr[i][j] =false;
                }
            }
        }
    }
    static void setnum(){
        String temp = "";
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]){
                    temp += Integer.toString(i+1)+" ";
                }
            }
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new boolean[n][];
        for(int i=0;i<n;i++){
            arr[i] = new boolean[m];
        }
        perm(0);

    }
}
