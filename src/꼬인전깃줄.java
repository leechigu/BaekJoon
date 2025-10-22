import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 꼬인전깃줄 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[n];
        int indx = 0;
        list[indx] = arr[0];
        for(int i=1;i<n;i++){
            if(list[indx]<arr[i]){
                indx++;
                list[indx] = arr[i];
            }else{
                int id = Arrays.binarySearch(list,0,indx+1,arr[i]);
                if(id<0){
                    id = -(id+1);
                }
                list[id] = arr[i];
            }
        }
        System.out.print(n-(indx+1));
    }
}
