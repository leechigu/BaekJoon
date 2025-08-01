    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트_dfs {

    public static int[] parent;

    public static int findRoot(int x){
        if(parent[x]!=x){
            parent[x]= findRoot(parent[x]);
        }
        return parent[x];
    }

    public static void unionRoot(int a,int b){

        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if(rootA<rootB){
            parent[b] = rootA;
        }else{
            parent[a] = rootB;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());

            parent = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                parent[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=n;i++){

                int a = i;
                int b = parent[i];
                System.out.println(a+" "+b);
                if(a==b)
                    continue;

                if(parent[a]!=parent[b]){
                    unionRoot(a,b);
                }else{
                }


            }



        }

    }
}
