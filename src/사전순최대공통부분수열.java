import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 사전순최대공통부분수열 {

    public static int n;
    public static int m;
    public static HashSet<String> hashSet = new HashSet<>();


    public static int compareList(List<Integer> a, List<Integer> b){

        int minLen = Math.min(a.size(),b.size());
        int maxLen = Math.max(a.size(),b.size());

        for(int i=0;i<minLen;i++){

            int aVal = a.get(i);
            int bVal = b.get(i);

            if(aVal>bVal)
                return 1;
            if(bVal>aVal)
                return -1;
        }

        if(maxLen==a.size()){
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.valueOf(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] b = new int[m];
        for(int i=0;i<m;i++){
            b[i] = Integer.valueOf(st.nextToken());
        }

        List<Integer>[][] dp = new ArrayList[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] = new ArrayList<>();
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1] == b[j-1]){
                    if(dp[i-1][j-1].isEmpty()){
                        dp[i][j].add(a[i-1]);
                    }else{
                        dp[i-1][j-1].add(a[i-1]);
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a[i-1]);
                        if(compareList(dp[i-1][j-1],temp)>0){
                            dp[i][j] = new ArrayList<>(dp[i-1][j-1]);
                        }else{
                            dp[i][j].add(a[i-1]);
                        }
                        int indx = 0;
                        boolean isReplace = false;
                        for(int k=0;k<dp[i][j].size();k++){
                            int t = dp[i][j].get(k);
                            if(t<a[i-1]){
                                indx = k;
                                isReplace=true;
                                break;
                            }
                        }

                        if(isReplace) {
                            temp = new ArrayList<>();
                            for (int k = 0; k < indx; k++) {
                                temp.add(dp[i][j].get(k));
                            }
                            temp.add(a[i - 1]);
                            dp[i][j] = new ArrayList<>(temp);
                        }

                    }
                }else{
                    if(compareList(dp[i-1][j],dp[i][j-1])>0){
                        dp[i][j] = new ArrayList<>(dp[i-1][j]);
                    }else{
                        dp[i][j] = new ArrayList<>(dp[i][j-1]);
                    }
                }
            }
        }
        if(dp[n][m].isEmpty()){
            System.out.println(0);
        }
        else {
            System.out.println(dp[n][m].size());
            StringBuilder sb = new StringBuilder();

            for(Integer val : dp[n][m]){
                sb.append(val).append(" ");
            }
            System.out.print(sb.toString());
        }
    }
}
