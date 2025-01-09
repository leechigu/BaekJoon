import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 신기한소수_Fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double max = 100000000;
        int sqrt = (int)Math.sqrt(max);

        int[] sqrtArr = new int[sqrt+1];

        List<Integer> sosuList = new ArrayList<>();
        sosuList.add(2);
        sosuList.add(3);

        for(int i=2;i<sqrtArr.length;i++){
            for(int j=2*i;j<sqrtArr.length;j+=i){
                //System.out.println(j);
                sqrtArr[j] = -1;
            }
        }

        for(int i=2;i<sqrtArr.length;i++){
            if(sqrtArr[i]==0){
                sosuList.add(i);
            }
        }

        int[] arr = new int[100000000];

        for(int sosu : sosuList){
            int cur =sosu *2;
            while(true){
                if(cur>=100000000)
                    break;
                arr[cur] = -1;
                cur+=sosu;
            }
        }

        for(int i=2;i<arr.length;i++){
        }


    }
}
