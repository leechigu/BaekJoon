package 백트래킹;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class N_Queen {

    static int num;
    static int count =0;
    static boolean[][] queen;
    static boolean isAlive = true;
    public static void dfs(int depth){

        if(depth==num){
            totalCheck();
            return;
        }
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if(queen[i][j]!=true){
                    queen[i][j] = true;
                    dfs(depth+1);
                    queen[i][j] = false;
                }
            }
        }
    }

    public static void totalCheck(){
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if(queen[i][j]==true){
                    check(i,j);
                }
            }
        }
        if(isAlive) {
            count++;
            isAlive =true;
        }
    }

    public static void check(int x,int y){
        int i=x;
        int j=y;
        while(true){
            i++;j++;
            if(i==num||j==num)
                break;
            if(queen[i][j]){
                isAlive = false;
            }
        }
        i=x;j=y;
        while(true){
            i--;j--;
            if(i==-1||j==-1){
                break;
            }
            if(queen[i][j]){
                isAlive=false;
                return;
            }
        }
        i=x;j=y;
        for(int k=0;k<num;k++){
            if(queen[i][k]){
                isAlive=false;
                return;
            }
        }
        for(int k=0;k<num;k++){
            if(queen[k][j]) {
                isAlive = false;
                return;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        num = Integer.parseInt(text);
        queen =new boolean[num][num];
        dfs(0);
        System.out.println(count);


    }
}
