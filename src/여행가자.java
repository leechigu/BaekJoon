import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {

    static int[] parent;

    static int findRoot(int x){

        if(x == parent[x])
            return x;

        return parent[x] = findRoot(parent[x]);
    }

    static void unionRoot(int x,int y){

        x = findRoot(x);
        y = findRoot(y);

        if(x!=y){
            parent[x] = y;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st =new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i=1;i<=n;i++)
            parent[i]=i;

        for(int i=1;i<=n;i++){
            input = br.readLine();
            st =new StringTokenizer(input);
            for(int j=1;j<=n;j++){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    unionRoot(i,j);
                }
            }
        }
        input = br.readLine();
        st =new StringTokenizer(input);

        int cur = Integer.parseInt(st.nextToken());
        boolean isPossible = true;
        while(st.hasMoreTokens()){
            int next = Integer.parseInt(st.nextToken());
            if(findRoot(cur)!=findRoot(next)){
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
