import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 패션왕신해빈 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(testCase-->0) {
            Map<String,Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                if (map.containsKey(type))
                    map.put(type, map.get(type) + 1);
                else
                    map.put(type, 1);
            }
            int keyCnt = map.keySet().size();

            int multiCase = 1;
            if (keyCnt == 0) {
                sb.append(0).append("\n");
            } else if (keyCnt == 1) {
                sb.append(map.get(map.keySet().iterator().next())).append("\n");
            } else {
                for (String key : map.keySet()) {
                    multiCase *= map.get(key)+1;
                }
                sb.append(multiCase-1).append("\n");
            }
        }
        System.out.print(sb);
    }
}
