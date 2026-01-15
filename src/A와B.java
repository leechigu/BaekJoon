import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A와B {

    static String a;
    static String b;

    public static void back(){

        StringBuilder sb = new StringBuilder(b);

        while(true){
            if(sb.length()==a.length()){
                if(a.equals(sb.toString())) {
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
                return;
            }

            if(sb.charAt(sb.length()-1)=='A'){
                sb = sb.deleteCharAt(sb.length()-1);
            }else{
                sb = sb.deleteCharAt(sb.length()-1);
                sb = sb.reverse();
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        back();
    }
}
