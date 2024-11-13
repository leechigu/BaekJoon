import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 거짓말 {

    static int[] parent;
    static ArrayList<Integer>[] edges;
    static ArrayList<Integer> realList;

    static int find_root(int x){
        if(x==parent[x])
            return x;
        return parent[x] = find_root(parent[x]);
    }

    static void union_root(int x, int y){

        x = find_root(x);
        y = find_root(y);
        if(realList.contains(y)){
            parent[x]=y;
        }else{
            parent[y]=x;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);
        int p = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        realList = new ArrayList<>();

        if(p>0) {
            for(int i=0;i<p;i++){
                realList.add(Integer.valueOf(st.nextToken()));
            }
        }else{
            System.out.println(m);
            return;
        }

        ArrayList<ArrayList<Integer>> partys = new ArrayList<>();

        for(int i=0;i<m;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            ArrayList<Integer> party = new ArrayList<>();
            int cnt = Integer.parseInt(st.nextToken());

            int cur = Integer.parseInt(st.nextToken());
            party.add(cur);
            for(int j=1;j<cnt;j++){
                int next = Integer.parseInt(st.nextToken());
                party.add(next);
                union_root(cur,next);
            }
            partys.add(party);
        }

        //check
        int answer = 0;
        for (ArrayList<Integer> party : partys) {
            boolean is = false;
            for (int i = 0; i < party.size(); i++) {
                int cur = party.get(i);
                if(realList.contains(find_root(cur))) {
                    is = true;
                    break;
                }
            }
            if (!is) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
