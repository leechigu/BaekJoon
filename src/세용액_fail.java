import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액_fail {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        long min = Long.MAX_VALUE;
        String answer = "";

        while(left<right-1){

            int mid = findMid(left,right);
            long sum = arr[left] + arr[mid] + arr[right];

            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                answer = arr[left] + " " + arr[mid] + " " + arr[right];
            }
            if(sum<0){
                left++;
            }else{
                right--;
            }
        }
        System.out.print(answer);
    }

    static int findMid(int start,int end){
        int a = start;
        int b = end;

        int target = (arr[a]+arr[b]) * -1;
        int minDif = target;
        int idx = (a+b)/2;
        int rtn = idx;

        while(a<b-2){

            if(arr[idx]==target){
                break;
            }
            if(arr[idx]<target){
                if(Math.abs(target+arr[idx])<minDif){
                    minDif = Math.abs(target+arr[idx]);
                    rtn = idx;
                }
                a=idx;
            }else{
                if(Math.abs(target+arr[idx])<minDif){
                    minDif = Math.abs(target+arr[idx]);
                    rtn = idx;
                }
                b=idx;
            }
            idx = (a+b)/2;
        }

        return rtn;
    }

}
