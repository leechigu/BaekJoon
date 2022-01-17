import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class baekjoon15651 {
    static int n;
    static int m;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void getNumSet(int depth)throws IOException{
        if(depth == m) {
            String temp ="";
            for(int i=0;i<m;i++){
                bw.write(Integer.toString(result[i]) + " ");
            }
            bw.newLine();
            return;
        }
        for(int i=0;i<n;i++){
            result[depth] = i+1;
            getNumSet(depth +1);
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        m =sc.nextInt();
        result = new int[n];
        getNumSet(0);
        bw.flush();
        bw.close();
    }
}
