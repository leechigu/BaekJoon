import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨 {

    static int[] button;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int cur = 100;

        int max = Math.max(n,cur);
        int min = Math.min(n,cur);

        int answer = max-min;

        if (m == 0) {
            String temp = String.valueOf(n);
            System.out.println(Math.min(answer,temp.length()));
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        button = new int[10];
        for (int i = 0; i < m; i++) {
            int broken = Integer.parseInt(st.nextToken());
            button[broken] = -1;
        }


        int[] number = new int[1000000];

        for(int i=0;i<number.length;i++){
            if(isPossible(i)){
                number[i] = 1;
            }
        }

        for(int i=0;i<number.length;i++){
            if(isPossible(i)){
                String temp = String.valueOf(i);
                int length = temp.length();
                int a = Math.max(i,n)-Math.min(i,n)+temp.length();
                answer = Math.min(a,answer);
            }
        }


        System.out.println(answer);
    }


    public static boolean isPossible(int num){
        String numStr = String.valueOf(num);
        char[] strArr = numStr.toCharArray();
        for(int i=0;i<strArr.length;i++){
            int cur = strArr[i] - '0';
            if(button[cur]==-1)
                return false;
        }

        return true;
    }

}
