import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장긴증가하는부분수열_2 {

    static int[] arr;
    static int[] list;
    public static int lowerbound(int left,int right, int target){
        int mid = 0;
        while(left<right){
            mid = (left+right)/2;
            if(target<=list[mid])
                right = mid;
            else
                left = mid+1;
        }
        return right;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);

        String[] strings = br.readLine().split(" ");
        arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(strings[i]);

        list = new int[n];
        int indx = 0;
        list[indx] = arr[0];

        for(int i=1;i<n;i++){
            if(arr[i]>list[indx]){
                indx++;
                list[indx] = arr[i];
            }
            else{
                int id = lowerbound(0,indx,arr[i]);
                list[id] = arr[i];
            }
        }

        System.out.println(indx+1);
    }
}
