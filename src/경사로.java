import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {

    static int[][] map;
    static boolean[][] stair;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        //계단 놓았는지 판단여부
        stair = new boolean[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        //가로 체크
        for(int i=0;i<n;i++) {

            boolean isPossible = true;
            int cur = map[i][0];
            for (int j = 1; j < n; j++) {
                int next = map[i][j];
                if(next-cur==1){
                    if(j-l<0){
                        isPossible = false;
                        break;
                    }
                    boolean s = true;
                    for(int k=j-l;k<j;k++){
                        if(map[i][k]==cur) {
                            if (stair[i][k]) {
                                s = false;
                                break;
                            }
                        }else{
                            s = false;
                            break;
                        }
                    }
                    if(s){
                        for(int k=j-l;k<j;k++){
                            stair[i][k] = true;
                        }
                    }else{
                        isPossible = false;
                        break;
                    }
                }else if(cur-next==1){
                    if(j+l-1>=n){
                        isPossible = false;
                        break;
                    }
                    boolean s = true;
                    for(int k=j+l-1;k>=j;k--){
                        if(map[i][k]==next) {
                            if (stair[i][k]) {
                                s = false;
                                break;
                            }
                        }else{
                            s = false;
                            break;
                        }
                    }
                    if(s){
                        for(int k=j+l-1;k>=j;k--){
                            stair[i][k] = true;
                        }
                    }else{
                        isPossible = false;
                        break;
                    }
                }else if(next==cur){
                    continue;
                }else{
                    isPossible = false;
                    break;
                }
                cur = next;
            }
            if(isPossible)
                answer++;
        }

        stair = new boolean[n][n];

        //세로 체크
        for(int j=0;j<n;j++) {

            boolean isPossible = true;
            int cur = map[0][j];
            for (int i = 1; i < n; i++) {
                int next = map[i][j];
                if(next-cur==1){
                    if(i-l<0){
                        isPossible = false;
                        break;
                    }
                    boolean s = true;
                    for(int k=i-l;k<i;k++){
                        if(map[k][j]==cur) {
                            if (stair[k][j]) {
                                s = false;
                                break;
                            }
                        }else{
                            s = false;
                            break;
                        }
                    }
                    if(s){
                        for(int k=i-l;k<i;k++){
                            stair[k][j] = true;
                        }
                    }else{
                        isPossible = false;
                        break;
                    }
                }else if(cur-next==1){
                    if(i+l-1>=n){
                        isPossible = false;
                        break;
                    }
                    boolean s = true;
                    for(int k=i+l-1;k>=i;k--){
                        if(map[k][j]==next) {
                            if (stair[k][j]) {
                                s = false;
                                break;
                            }
                        }else{
                            s = false;
                            break;
                        }
                    }
                    if(s){
                        for(int k=i+l-1;k>=i;k--){
                            stair[k][j] = true;
                        }
                    }else{
                        isPossible = false;
                        break;
                    }
                }else if(next==cur){
                    continue;
                }else{
                    isPossible = false;
                    break;
                }
                cur = next;
            }

            if(isPossible)
                answer++;
        }

        System.out.print(answer);

    }
}
