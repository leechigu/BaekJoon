import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {

    static int c;
    static int l;
    static char[] words;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    static char[] ahdma = {'a','e','i','o','u'};


    public static boolean checkAhdma(char x){
        for(int i=0;i<5;i++){
            if(x==ahdma[i])
                return true;
        }
        return false;
    }

    public static void dfs(int depth,String val, int cur,int ahdmaCnt,int wkdmaCnt){

        if(depth==l){
            if(ahdmaCnt>=1&&wkdmaCnt>=2){
                sb.append(val).append("\n");
            }

            return;
        }

        for(int i=cur;i<c;i++){
            if(!isVisited[i]) {
                isVisited[i] = true;
                int nextAhdma = ahdmaCnt;
                int nextWkdma = wkdmaCnt;
                if(checkAhdma(words[i])){
                    nextAhdma++;
                }else{
                    nextWkdma++;
                }
                dfs(depth + 1, val + words[i], i,nextAhdma,nextWkdma);
                isVisited[i] = false;
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        words = new char[c];
        isVisited = new boolean[c];

        for(int i=0;i<c;i++)
            words[i] = st.nextToken().charAt(0);

        Arrays.sort(words);

        dfs(0,"",0,0,0);
        System.out.print(sb);
    }
}
