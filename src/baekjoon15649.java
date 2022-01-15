import java.util.Scanner;

public class baekjoon15649 {
    static int n;
    static int m;
    static int[] resultArray;
    static boolean[] isVisited;
    static int[] initArray;
    public static void permutation(int depth){
        if(depth ==m){
            print();
            return;
        }
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                isVisited[i] =true;
                resultArray[depth] =initArray[i];
                permutation(depth+1);
                isVisited[i] =false;
            }
        }

    }

    static void print(){
        for(int i=0;i<m;i++){
            System.out.print(resultArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        initArray = new int[n];
        for(int i = 0;i< initArray.length;i++){
            initArray[i] =i+1;
        }
        resultArray =new int[n];
        isVisited = new boolean[n];
        for(int i =0; i< isVisited.length;i++){
            isVisited[i] =false;
        }
        permutation(0);

    }

}
