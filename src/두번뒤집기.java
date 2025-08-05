
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두번뒤집기 {

    static int[] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void doCase1(int[] arr){

        int min = 0;
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                min = i;
                break;
            }
        }
        int max = min+1;
        for(int i=min+1;i<n;i++){
            if(arr[i]==i+1){
                max = i-1;
            }
        }
        System.out.println(min+" "+max);
        min = max+1;
        for(int i=min;i<n;i++){
            if(arr[i]!=i+1){
                min = i;
                break;
            }
        }

        max = n-1;
        for(int i=min+1;i<n;i++){
            if(arr[i]==i+1){
                max = i-1;
            }
        }
        System.out.println(min+" "+max);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int min =n;
        int max =1;
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                min = Math.min(min,i+1);
                max = Math.max(max,i+1);
            }
        }

        if(min==n&&max==1){
            System.out.println(1+" "+1);
            System.out.print(1+" "+1);
            return;
        }


        //case2 포함

        int maxIndx = -1;
        int minIndx = -1;

        for(int i=0;i<n;i++){
            if(arr[i]==min)
                minIndx = i;
            if(arr[i]==max)
                maxIndx =i;
        }

        if(maxIndx==min-1&&minIndx==max-1){
            int[] temp = rotate(arr,min-1,max-1);
            if(isPossible(temp,min-1,max-1)){
                System.out.print(sb.toString());
                return;
            }
        }

        int[] c1 = rotate(arr,min-1,minIndx);

        int[] c2 = rotate(arr,maxIndx,max-1);

        //System.out.println((min-1)+" ,"+(minIndx));
        if(isPossible(c1,min-1,minIndx)){
            System.out.print(sb.toString());
            return;
        }
        //System.out.println((maxIndx)+" ,"+(max-1));
        if(isPossible(c2,maxIndx,max-1)){
            System.out.print(sb.toString());
            return;
        }
        //case1 포함 X
        boolean x = true;
        int cnt = 0;

        for(int i=1;i<n;i++){
            if(arr[i]==i+1){
                x= false;
                continue;
            }
            if(!x&&arr[i]!=i+1){
                x = true;
                cnt++;
            }
        }

        if(cnt==2){
            doCase1(arr);
        }


    }

    public static int[] rotate(int[] arr,int st,int end){
        int[] temp = arr.clone();
        for(int i=0;i<=end-st;i++){
            temp[st+i]=arr[end-i];
        }
        return temp;
    }

    public static boolean isPossible(int[] arr,int st,int end){
        int min = n-1;
        int max = 0;
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                min = Math.min(min,i);
                max = Math.max(max,i);
            }
        }

        int[] temp = rotate(arr,min,max);
        boolean possible = true;
        for(int i=0;i<n;i++){
            if(temp[i]!=i+1){
                possible = false;
                break;
            }
        }
        if(possible){
            sb.append(st+1).append(" ").append(end+1).append("\n");
            if (min == n - 1 && max == 0) {
                sb.append(1).append(" ").append(1);
            }else {
                sb.append(min + 1).append(" ").append(max + 1);
            }
        }
        return possible;
    }

}
