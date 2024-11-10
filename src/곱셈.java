import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 곱셈 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        long a = Long.parseLong(splitStr[0]);
        int b = Integer.parseInt(splitStr[1]);
        long c = Long.parseLong(splitStr[2]);
        long answer = 1;
        a %=c;

        while(b>0){
            if(b%2==1){
                answer = (answer * a) %c;
            }
            b/=2;
            a = (a*a)%c;
        }
        System.out.println(answer);
    }
}
