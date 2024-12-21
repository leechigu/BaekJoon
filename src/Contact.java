import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Contact {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        //(100+1+ | 01)+
        Pattern p = Pattern.compile("(100+1+|01)+");
        for(int i=0;i<t;i++){
            String cur = br.readLine();
            if(p.matcher(cur).matches()){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}
