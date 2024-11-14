import javax.swing.*;
import java.io.*;
import java.util.*;

public class 친구네트워크 {

    static int[] parent;
    static int[] level;

    static int findRoot(int x){
        if(parent[x] ==x)
            return x;
        return parent[x] = findRoot(parent[x]);
    }

    static int unionRoot(int x,int y) {

        x = findRoot(x);
        y = findRoot(y);

        if (x != y) {
            parent[y] = x;
            level[x] += level[y];

        }
        return level[x];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(input);

        for (int seq = 0; seq < t; seq++) {
            int f = Integer.parseInt(br.readLine());
            parent = new int[f*2];
            level = new int[f*2];

            for(int i=0;i<f*2;i++) {
                parent[i] = i;
                level[i] = 1;
            }

            int indx =0;
            Map<String,Integer> nameMap = new HashMap<>();

            for(int i=0;i<f;i++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!nameMap.containsKey(a))
                    nameMap.put(a,indx++);

                if(!nameMap.containsKey(b))
                    nameMap.put(b,indx++);

                int answer = unionRoot(nameMap.get(a),nameMap.get(b));

                sb.append(answer).append("\n");
            }
        }
        System.out.print(sb);
    }
}
