import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 소수의연속합 {

    //static int max = 4000000;
    public static List<Integer> getSosuList(int n){
        boolean[] isSosu = new boolean[n+1];
        Arrays.fill(isSosu,true);
        List<Integer> sosuList = new ArrayList<>();

        for(int i=2;i*i<=n;i++){
            if(isSosu[i]){
                for(int j=2;j*i<=n;j++){
                    isSosu[j*i] = false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(isSosu[i])
                sosuList.add(i);
        }
        return sosuList;
    }
    public static void main(String[] args) throws IOException {


    }
}
