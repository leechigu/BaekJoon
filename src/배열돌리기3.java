import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 배열돌리기3 {

    static int n;
    static int m;

    public static int[][][] splitMap(int[][] curMap){

        int[][][] splitedMap = new int[4][curMap.length/2][curMap[0].length/2];

        for(int i=0;i<curMap.length/2;i++){
            for(int j=0;j<curMap[0].length/2;j++){
                splitedMap[0][i][j] = curMap[i][j];
            }
        }

        for(int i=0;i<curMap.length/2;i++){
            for(int j=0;j<curMap[0].length/2;j++){
                splitedMap[1][i][j] = curMap[i+curMap.length/2][j];
            }
        }

        for(int i=0;i<curMap.length/2;i++){
            for(int j=0;j<curMap[0].length/2;j++){
                splitedMap[2][i][j] = curMap[i][j+curMap[0].length/2];
            }
        }

        for(int i=0;i<curMap.length/2;i++){
            for(int j=0;j<curMap[0].length/2;j++){
                splitedMap[3][i][j] = curMap[i+curMap.length/2][j+curMap[0].length/2];
            }
        }

        return splitedMap;
    }


    public static int[][] doFunc(int funcType,int[][] curMap){


        if(funcType==1){
            return func1(curMap);
        }else if(funcType==2){
            return func2(curMap);
        }else if(funcType==3){
            return func3(curMap);
        }else if(funcType==4){
            return func4(curMap);
        }else if(funcType==5){
            return func5(curMap);
        }else if(funcType==6){
            return func6(curMap);
        }

        return null;

    }

    private static int[][] func1(int[][] target) {
        int[][] result = new int[target.length][target[0].length];
        for(int i=0;i<target[0].length;i++){
            for(int j=0;j<target.length;j++){
                result[j][i] = target[target.length-1-j][i];
            }
        }
        return result;
    }

    private static int[][] func2(int[][] target) {
        int[][] result = new int[target.length][target[0].length];
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                result[i][j] = target[i][result[0].length-1-j];
            }
        }
        return result;
    }

    private static int[][] func3(int[][] target) {
        int[][] result = new int[target[0].length][target.length];
        for(int i=0;i< target.length;i++){
            for(int j=0;j<target[0].length;j++){
                result[j][i] = target[i][j];
            }
        }
        return func2(result);
    }

    private static int[][] func4(int[][] target) {
        int[][] result = new int[target[0].length][target.length];
        for(int i=0;i< target.length;i++){
            for(int j=0;j<target[0].length;j++){
                result[j][i] = target[i][j];
            }
        }
        return func1(result);
    }

    private static int[][] func5(int[][] target){
        int[][] result =  new int[target.length][target[0].length];

        int[][][] splitedMap = splitMap(target);

        for(int i=0;i<target.length/2;i++){
            for(int j=0;j<target[0].length/2;j++){
                result[i][j] = splitedMap[1][i][j];
            }
        }
        for(int i=0;i<target.length/2;i++){
            for(int j=target[0].length/2;j<target[0].length;j++){
                result[i][j] = splitedMap[0][i][j-target[0].length/2];
            }
        }
        for(int i=target.length/2;i<target.length;i++){
            for(int j=0;j<target[0].length/2;j++){
                result[i][j] = splitedMap[3][i-target.length/2][j];
            }
        }
        for(int i=target.length/2;i<target.length;i++){
            for(int j=target[0].length/2;j<target[0].length;j++){
                result[i][j] = splitedMap[2][i-target.length/2][j-target[0].length/2];
            }
        }
        return result;
    }


    private static int[][] func6(int[][] target){
        int[][] result =  new int[target.length][target[0].length];

        int[][][] splitedMap = splitMap(target);

        for(int i=0;i<target.length/2;i++){
            for(int j=0;j<target[0].length/2;j++){
                result[i][j] = splitedMap[2][i][j];
            }
        }
        for(int i=0;i<target.length/2;i++){
            for(int j=target[0].length/2;j<target[0].length;j++){
                result[i][j] = splitedMap[3][i][j-target[0].length/2];
            }
        }
        for(int i=target.length/2;i<target.length;i++){
            for(int j=0;j<target[0].length/2;j++){
                result[i][j] = splitedMap[0][i-target.length/2][j];
            }
        }
        for(int i=target.length/2;i<target.length;i++){
            for(int j=target[0].length/2;j<target[0].length;j++){
                result[i][j] = splitedMap[1][i-target.length/2][j-target[0].length/2];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] funcs = new int[r];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<r;i++){
            funcs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<funcs.length;i++){
            map = doFunc(funcs[i],map);
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
