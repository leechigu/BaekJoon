import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AtoB_DFS {


    static int min = -1;
    static long target;
    static void dfs(int seq,long val) {
        if (val > target)
            return;

        if (val == target) {
            if (min == -1)
                min = seq;
            else
                min = Math.min(min, seq);
            return;
        }


        dfs(seq + 1, val * 2);
        String temp = String.valueOf(val);
        temp = temp + "1";
        long nextVal = Long.parseLong(temp);
        if (nextVal <= target)
            dfs(seq + 1, nextVal);

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");
        int a = Integer.parseInt(splitStr[0]);
        long b = Integer.parseInt(splitStr[1]);
        target = b;


        dfs(0,a);

        if(min==-1)
            System.out.println(min);
        else
            System.out.println(min+1);

    }
}
