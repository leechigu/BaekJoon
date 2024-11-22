import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI_성공 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int answer = 0;

        String str = br.readLine();
        char[] strArr = str.toCharArray();
        int count = 0;
        for(int i=1;i<m-1;i++){
            if(strArr[i-1]=='I'&&strArr[i]=='O'&&strArr[i+1]=='I'){
                count++;
                i++;
                //System.out.println(count);
                if(count==n){
                    answer++;
                    count--;
                }
            }else{
                count=0;
            }
        }

        System.out.println(answer);

    }
}
