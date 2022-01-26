import java.util.Arrays;
import java.util.Scanner;

public class 좌표_정렬하기 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x,y;
        int[][] arr = new int [n][2];


        for(int i=0;i<n;i++){
            x = sc.nextInt();
            y = sc.nextInt();
            arr[i][0] = x;
            arr[i][1] = y;
        }
        Arrays.sort(arr, (e1,e2)-> {
            if(e1[0] == e2[0]){
                return e1[1]-e2[1];
            }
            else{
                return e1[0]-e2[0];
            }
        });
        for(int i=0;i<n;i++){
            System.out.println(arr[i][0] + " "+arr[i][1]);
        }

    }
}
