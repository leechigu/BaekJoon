import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스토쿠2580 {

    static int[][] map = new int[9][9];
    static boolean[][] check1 = new boolean[9][10];
    static boolean[][] check2 = new boolean[9][10];
    static boolean[][] check3 = new boolean[9][10];
    static int cnt=0;
    static StringBuilder sb = new StringBuilder();

    static int squareZone(int x,int y){
        return (y/3)*3+(x/3);
    }

    static boolean sudoku(int cur){
        cnt++;
        if(cnt>=10000000){
            return false;
        }

        if(cur==81){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return true;
        }

        int x = cur%9;
        int y = cur/9;

        if(map[y][x]!=0){
            return sudoku(cur+1);
        }else{
            for(int i=1;i<=9;i++){
                if(!check1[x][i] && !check2[y][i] && !check3[squareZone(x,y)][i]){
                    check1[x][i] = true;
                    check2[y][i] = true;
                    check3[squareZone(x,y)][i] = true;
                    map[y][x] = i;
                    if(!sudoku(cur+1)){
                        check1[x][i] = false;
                        check2[y][i] = false;
                        check3[squareZone(x,y)][i] = false;
                        map[y][x] = 0;
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i=0;i<9;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                map[i][j] = st.nextToken().charAt(0) - '0';
                if (map[i][j] != 0) {
                    check1[j][map[i][j]] = true;
                    check2[i][map[i][j]] = true;
                    check3[squareZone(j, i)][map[i][j]] = true;
                }
            }
        }

        sudoku(0);
        System.out.println(sb.toString());

    }
}
