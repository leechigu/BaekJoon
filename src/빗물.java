import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());




        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for(int i=0;i<w;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] len = new int[w];

        len[0] = arr[0];

        for(int i=1;i<w;i++){
            if(arr[i]>len[i-1]){
                len[i] = arr[i];
            }else{
                len[i] = len[i-1];
            }
        }

        len[w-1] = arr[w-1];

        for(int i=w-2;i>=0;i--){
            if(arr[i]>len[i+1]){
                len[i] = Math.min(len[i],arr[i]);
            }else{
                len[i] = Math.min(len[i],len[i+1]);
            }
        }

        int answer = 0;
        for(int i=0;i<w;i++){
            answer+=len[i]-arr[i];
        }
        System.out.println(answer);
    }
}
