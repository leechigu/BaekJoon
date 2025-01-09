import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영식이의손가락 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int brokenIndx = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());

        long answer =0;
        if(brokenIndx==1){
            answer+= 8L *cnt;
        }else if(brokenIndx==5){
            answer+= 8L *cnt + 4;
        }else{
            if(cnt%2==0){
                answer+= 8L *(cnt/2);
                if(brokenIndx==2)
                    answer+=1;
                else if(brokenIndx==3)
                    answer+=2;
                else if(brokenIndx==4)
                    answer+=3;
            }else{
                answer+= 8L *(cnt/2);
                if(brokenIndx==2)
                    answer+=7;
                else if(brokenIndx==3)
                    answer+=6;
                else if(brokenIndx==4)
                    answer+=5;
            }
        }
        System.out.print(answer);
    }
}
