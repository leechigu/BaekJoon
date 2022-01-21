import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon2108 {

    public static void main(String[] args) throws IOException {
        int [] nums = new int [8001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }//입력

        int sum=0;
        for(int i = 0; i<n;i++){
            sum +=arr[i];
        }//산술평균
        double temp =sum;
        temp = Math.round(temp/n);
        int a = (int) temp;
        bw.write(String.valueOf(a));
        bw.write("\n");
        Arrays.sort(arr);
        bw.write(String.valueOf(arr[n/2]));
        bw.write("\n");


        for(int i=0;i<n;i++){
            nums[arr[i]+4000]++;
        }
        int maxCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxCount)
                maxCount = nums[i];
        }

        ArrayList<Integer> x = new ArrayList<>();

        int c = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==maxCount) {
                c++;
                x.add(i - 4000);
            }
        }
        int[] at = new int[x.size()];
        for(int i=0;i<at.length;i++){
            at[i] = x.get(i);
        }
        Arrays.sort(at);
        if(c>=2){
            bw.write(String.valueOf(at[at.length-c+1]));
            bw.write("\n");
        }
        else{
            bw.write(String.valueOf(at[at.length-1]));
            bw.write("\n");
        }


        int range = arr[n-1]-arr[0];
        bw.write(String.valueOf(range));
        bw.write("\n");
        br.close();
        bw.close();
    }

}
