import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 곱셈_메모리초과 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        long a = Long.parseLong(splitStr[0]);
        int b = Integer.parseInt(splitStr[1]);
        long c = Long.parseLong(splitStr[2]);
        int cur = 0;

        Map<Integer,Long> map = new HashMap<>();

        map.put(1,(a%c));

        for(int i=2;i<=b;i*=2){
            a = (a%c)*(a%c);
            a = a%c;
            cur = i;
            map.put(cur,a);
            //System.out.println(cur +" "+a);
        }


        int remain = b - cur;

        while (true) {

            if(cur==0)
                break;
            if(remain==0)
                break;

            cur /= 2;
            if (remain >= cur) {
                long temp = map.get(cur);
                //System.out.println(cur + " "+temp);
                a = (a%c)*(temp%c);
                a = a%c;
                remain -= cur;
            }
        }
        a = a%c;
        System.out.println(a);

    }
}
