import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 합이0인네정수 {

    static int[] s1, s2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][4];

        StringTokenizer st = null;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        s1 = new int[n*n];
        s2 = new int[n*n];

        int indx = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                s1[indx] = arr[i][0] + arr[j][1];
                s2[indx] = arr[i][2] + arr[j][3];
                indx++;
            }
        }

        Arrays.sort(s1);
        Arrays.sort(s2);

        long answer = 0;
        int left = 0;
        int right = n*n-1;

        while(left<n*n && right>=0){
            if(s1[left] + s2[right] <0){
                left++;
            }else if(s1[left] + s2[right] > 0){
                right--;
            }else{
                int leftCnt = 0;
                int rightCnt = 0;

                for (int i = left; i < n*n; i++) {
                    if (s1[i] == s1[left]) {
                        leftCnt++;
                    } else {
                        break;
                    }
                }

                for (int i = right; i >=0; i--) {
                    if (s2[i] == s2[right]) {
                        rightCnt++;
                    } else {
                        break;
                    }
                }

                left += leftCnt;
                right -= rightCnt;

                answer += (long) leftCnt * rightCnt;

            }
        }

        System.out.println(answer);
    }
}
