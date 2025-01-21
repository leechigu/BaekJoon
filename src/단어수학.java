import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어수학 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String[] originNums = new String[n];
        String[] nums = new String[n];
        for(int i=0;i<n;i++) {
            sb = new StringBuilder(br.readLine());
            originNums[i] = sb.toString();
            String num = sb.reverse().toString();
            nums[i] =num;
        }

        List<Character> cList = new ArrayList<>();
        for(int i=0;i<n;i++){
            String originNum = originNums[i];
            for(int j=0;j<originNum.length();j++){
                char c = originNum.charAt(j);
                if(!cList.contains(c)){
                    cList.add(c);
                }
            }
        }
        int[][] cnt = new int[8][cList.size()];

        for(int i=0;i<n;i++){
            String cur = nums[i];
            for(int j=0;j<cur.length();j++){
                char a = cur.charAt(j);
                cnt[j][cList.indexOf(a)]++;
            }
        }
        int[] val = new int[cList.size()];
        for(int i=0;i<cList.size();i++){
            int m = 1;
            int sum = 0;
            for(int j=0;j<8;j++){
                sum+=(m*cnt[j][i]);
                m*=10;
            }
            val[i] = sum;
        }
        Arrays.sort(val);
        int answer = 0;
        int curMaxVal = 9;

        for(int i=val.length-1;i>=0;i--){
            answer+=val[i]* curMaxVal;
            curMaxVal--;
        }
        System.out.print(answer);

    }
}
