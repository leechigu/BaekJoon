import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사회망서비스_fail {

    static int min = Integer.MAX_VALUE;
    static int[] parent;
    static int[] len;
    static boolean[] isChecked;
    static List<Integer>[] lists;

    static int findParent(int a){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }

    static void union(int a, int b){
        int parentA = findParent(a);
        int parentB = findParent(b);

        if(len[parentA]>=len[parentB]){
            len[parentA]++;
            parent[parentB] = parentA;
            lists[a].add(b);
        }else{
            len[parentB]++;
            parent[parentA] = parentB;
            lists[b].add(a);
        }
    }

    static boolean levelCnt(int cur){
        boolean check = false;

        for(int i : lists[cur]){
            if(lists[i].isEmpty()){
                check = true;
            }
        }

        for(int i : lists[cur]){
            if(!lists[i].isEmpty()){
                boolean next = levelCnt(i);
                if(!next){
                    check = true;
                }
            }
        }

        if(check){
            isChecked[cur] = true;
        }
        return check;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        parent = new int[n+1];
        len = new int[n+1];
        isChecked = new boolean[n+1];
        lists = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            lists[i] = new ArrayList<>();
            parent[i] =i;
            len[i] = 1;
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int root = findParent(1);

        levelCnt(root);

        int answer = 0;
        for(int i=1;i<=n;i++){
            if(isChecked[i]){
                answer++;
            }
        }
        System.out.print(answer);
    }
}
