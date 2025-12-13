import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {

    static int n;
    static int size;
    static long[] node;
    static StringBuilder sb = new StringBuilder();

    public static long init(int indx){
        if(indx>=size){
            return node[indx];
        }
        return node[indx] = init(indx*2)+init(indx*2+1);
    }

    public static void update(int indx){
        if(indx==0){
            return;
        }
        node[indx] = node[indx*2] + node[indx*2+1];
        update(indx/2);
    }

    public static void search(int st, int ed){

        st+=size-1;
        ed+=size-1;

        long sum = 0;
        while(true){
            if(st%2==1){
                sum+=node[st];
                st++;
            }
            if(ed%2==0){
                sum+=node[ed];
                ed--;
            }
            if(st>ed){
                break;
            }
            st/=2;
            ed/=2;
        }
        sb.append(sum).append("\n");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        size = 1;
        while(size<n){
            size*=2;
        }

        node  = new long[size*2];

        for(int i=0;i<n;i++){
            node[i+size] = Long.parseLong(br.readLine());
        }

        init(1);

        for(int i=0;i<m+k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a==1){
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                node[b+size-1] = c;
                update((b+size-1)/2);

            }else if(a==2){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                search(b,c);
            }
        }
        System.out.print(sb.toString());
    }
}
