import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 신기한소수 {

    public static List<Integer> sosuList;
    static StringBuilder sb = new StringBuilder();

    public static boolean isSosu(int num){
        if(num==1)
            return false;
        for(int sosu : sosuList){
            if(sosu>=num)
                break;
            if(num%sosu==0)
                return false;
        }
        return true;
    }

    static void dfs(int num, int n){

        if(n==0){
            sb.append(num).append("\n");
            return;
        }

        for(int i=1;i<10;i++){
            int temp = num*10+i; //this is key point!!
            if(isSosu(temp)){
               dfs(temp,n-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double max = 100000000;
        int sqrt = (int)Math.sqrt(max);

        int[] sqrtArr = new int[sqrt+1];

        sosuList = new ArrayList<>();

        for(int i=2;i<sqrtArr.length;i++){
            for(int j=2*i;j<sqrtArr.length;j+=i){
                sqrtArr[j] = -1;
            }
        }

        for(int i=2;i<sqrtArr.length;i++){
            if(sqrtArr[i]==0){
                sosuList.add(i);
            }
        }

        dfs(0,n);
        System.out.print(sb);
    }
}
