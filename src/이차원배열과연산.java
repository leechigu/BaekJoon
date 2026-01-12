import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이차원배열과연산 {

    static int[][] map = new int[100][100];
    static int m=3; static int n=3;
    static int r;
    static int c;
    static int k;

    public static int cal(){
        int answer = 0;
        while(true){
            if(answer==101){
                answer = -1;
                break;
            }
            if(map[r][c]==k){
                break;
            }
            if(n>=m){
                R();
            }else{
                C();
            }
            answer++;

        }
        return answer;
    }

    static int[] numArr;
    static Set<Integer> numSet;

    static void R(){

        int nextM = -1;

        for(int i=0;i<n;i++){
            numArr = new int[101];
            numSet = new HashSet<>();
            for(int j=0;j<m;j++){
                int cur = map[i][j];
                if(cur==0)
                    continue;
                numArr[cur]++;
                numSet.add(cur);
            }
            int[][] temp = new int[numSet.size()][2];
            int indx=0;
            for(int num : numSet){
                temp[indx][0] = num;
                temp[indx][1] = numArr[num];
                indx++;
            }

            Arrays.sort(temp, new Comparator<>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1]){
                        return o1[0]-o2[0];
                    }

                    return o1[1]-o2[1];
                }
            });

            nextM = Math.max(Math.min(100,numSet.size()*2),nextM);

            for(int j=0;j<100;j++){
                map[i][j] = 0;
            }

            for(int j=0;j<numSet.size();j++){
                map[i][j*2]=temp[j][0];
                map[i][j*2+1] = temp[j][1];
            }
        }
        m = nextM;
    }

    static void C(){
        int nextN= -1;
        for(int j=0;j<m;j++){
            numArr = new int[101];
            numSet = new HashSet<>();
            for(int i=0;i<n;i++){
                int cur = map[i][j];
                if(cur==0)
                    continue;
                numArr[cur]++;
                numSet.add(cur);
            }
            int[][] temp = new int[numSet.size()][2];
            int indx=0;
            for(int num : numSet){
                temp[indx][0] = num;
                temp[indx][1] = numArr[num];
                indx++;
            }

            Arrays.sort(temp, new Comparator<>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1]){
                        return o1[0]-o2[0];
                    }
                    return o1[1]-o2[1];
                }
            });

            nextN = Math.max(Math.min(100,numSet.size()*2),nextN);

            for(int i=0;i<100;i++){
                map[i][j] = 0;
            }

            for(int i=0;i<numSet.size();i++){
                map[i*2][j] = temp[i][0];
                map[i*2+1][j] = temp[i][1];
            }

        }
        n = nextN;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(cal());
    }
}
