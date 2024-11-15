import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split("-");
        String first = splitStr[0];
        String[] headSplit = first.split("\\+");
        int total = 0;
        for(int i=0;i<headSplit.length;i++){
            int temp = Integer.parseInt(headSplit[i]);
            total+=temp;
        }
        for(int i=1;i<splitStr.length;i++){
            String cur = splitStr[i];
            String[] plusList = cur.split("\\+");
            int plus = 0;
            for(int j=0;j<plusList.length;j++){
                int temp = Integer.parseInt(plusList[j]);
                plus +=temp;
            }
            total-=plus;
        }
        System.out.println(total);
    }
}
