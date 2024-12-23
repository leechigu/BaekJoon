import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의개수 {


    static int answer1=0;
    static int answer2=0;
    static int answer3=0;


    static int[][] map;
    static int n;
    static void recursiveFunc(int y,int x, int size){
        if(size==0)
            return;
        int firstVal = map[y][x];
        boolean isPossible = true;
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                int cur = map[i][j];
                if(firstVal!=cur){
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible)
                break;
        }

        if(isPossible){
            if(firstVal == -1)
                answer1++;
            else if(firstVal == 0)
                answer2++;
            else if(firstVal == 1)
                answer3++;
        }else{
            int nextSize = size/3;
            for(int i=y;i<y+size;i+=nextSize){
                for(int j=x;j<x+size;j+=nextSize){
                    recursiveFunc(i,j,nextSize);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursiveFunc(0,0,n);

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }
}
