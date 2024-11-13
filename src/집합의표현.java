import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 집합의표현 {

    static int[] parent;

    static int findRoot(int x){

        if(x==parent[x]){
            return x;
        }

        return parent[x] = findRoot(parent[x]);
    }

    static void unionRoot(int x,int y){
        x = findRoot(x);
        y = findRoot(y);

        if(x!=y){
            parent[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st =new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1;i<=n;i++)
            parent[i] = i;

        for(int i=0;i<m;i++){
            input = br.readLine();
            st =new StringTokenizer(input);

            int caseNum = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(caseNum==0){
                unionRoot(a,b);
            }else if(caseNum == 1){
                if(findRoot(a)==findRoot(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }
        }
    }
}
