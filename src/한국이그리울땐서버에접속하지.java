import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class 한국이그리울땐서버에접속하지 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String star = br.readLine();
        String[] splitStr = star.split("\\*");

        Pattern p = Pattern.compile(splitStr[0]+".*"+splitStr[1]);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){

            String cur = br.readLine();
            if(p.matcher(cur).matches())
                sb.append("DA").append("\n");
            else
                sb.append("NE").append("\n");

        }

        System.out.print(sb);
    }
}
