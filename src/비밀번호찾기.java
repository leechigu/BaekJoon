import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 비밀번호찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,String> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            String temp = br.readLine();
            st = new StringTokenizer(temp);
            String url = st.nextToken();
            String password = st.nextToken();
            hashMap.put(url,password);
        }

        for(int i=0;i<m;i++)
            sb.append(hashMap.get(br.readLine())).append("\n");
        System.out.print(sb);
    }
}
