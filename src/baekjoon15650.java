import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon15650 {
    static int n;
    static int m;
    static int[] resultArray;
    static boolean[] isVisited;
    static int[] initArray;
    static ArrayList<String> result;
    public static void permutation(int depth){
        if(depth ==m){
            print();
            return;
        }
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                isVisited[i] =true;
                permutation(depth+1);
                isVisited[i] =false;
            }
        }
    }
    static void print(){
        String temp = "";
        for(int i=0;i<isVisited.length;i++){
            if(isVisited[i]){
                temp +=Integer.toString(initArray[i])+" ";
            }
        }
        if(!result.contains(temp)){
            result.add(temp);
        }
    }
    public static void main(String[] args) {
        result = new ArrayList<>();
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
        for(int i = 0; i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
