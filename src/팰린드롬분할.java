import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬분할 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int len = input.length();

        char[] chars = new char[len];
        for(int i=0;i<len;i++){
            chars[i] = input.charAt(i);
        }

        boolean[][] palDp = new boolean[len][len];

        for(int i=0;i<len;i++){
            palDp[i][i] = true;
        }

        for(int i=0;i<len;i++){
            for(int j=i-1;j>=0;j--){

                int beforeA = j+1;
                int beforeB = i-1;
                if(beforeA>beforeB){
                    if(chars[j]==chars[i]){
                        palDp[j][i]= true;
                    }
                    continue;
                }

                if(palDp[beforeA][beforeB]){
                    if(chars[j]==chars[i]){
                        palDp[j][i] = true;
                    }
                }
            }
        }

        int[] answerDp = new int[len+1];

        for(int i=1;i<=len;i++){
            answerDp[i] = answerDp[i-1]+1;
            for(int j=1;j<i;j++) {
                if(palDp[j-1][i-1]){
                    answerDp[i] = Math.min(answerDp[i],answerDp[j-1]+1);
                }
            }
        }

        System.out.print(answerDp[len]);
    }
}
