import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 이진검색트리 {

    static int[] arr;
    static StringBuilder sb;
    public static void find(int st,int end){
        if(st>=end)
            return;

        int curVal = arr[st];
        int next = st+1;
        int rightIndx = next;
        for(int i=next;i<end;i++){
            if(arr[i]>curVal){
                rightIndx = i;
                break;
            }
        }

        find(next,rightIndx);
        find(rightIndx,end);
        sb.append(curVal).append("\n");

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrList =new ArrayList<>();
        while(sc.hasNextInt()){
            arrList.add(sc.nextInt());
        }

        arr = new int[arrList.size()];
        for(int i=0;i<arrList.size();i++){
            arr[i] = arrList.get(i);
        }
        sb = new StringBuilder();
        find(0,arrList.size());

        System.out.print(sb.toString());
    }
}
