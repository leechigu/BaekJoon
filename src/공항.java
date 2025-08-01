import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공항 {

    static int[] gate;

    static int findRoot(int a){
        if(a==gate[a])
            return a;
        return gate[a] = findRoot(gate[a]);
    }

    static void union(int a, int b){
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if(rootA<rootB){
            gate[b] = rootA;
        }else{
            gate[a] = rootB;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        gate = new int[g+1];

        for(int i=1;i<=g;i++){
            gate[i] = i;
        }

        int answer = 0;

        for(int i=0;i<p;i++){
            int x = Integer.parseInt(br.readLine());
            if(findRoot(x)==0)
                break;
            union(findRoot(x)-1,findRoot(x));
            answer++;

        }
        System.out.print(answer);
    }
}
