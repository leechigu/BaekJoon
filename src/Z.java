import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Z {


    public static int Z(int n,int c,int r){
        int seq = 0;

        //x1, x2, y1, y2
        int [] cur = new int[]{0,n,0,n};

        while(true){
            int x1 = cur[0];
            int x2 = cur[1];
            int y1 = cur[2];
            int y2 = cur[3];

            int a = x2-x1;

            if(a==1)
                return seq;

            a=a/2;

            if(r >= x1+a && r < x2 && c >= y1+a && c < y2) {
                seq = seq + (a*a)*3;
                cur = new int[]{x1 + a, x2, y1 + a, y2};
            }
            if(r >= x1 && r < x1+a && c >= y1+a && c < y2) {
                seq = seq + (a*a)*2;
                cur = new int[]{x1, x1 + a, y1 + a, y2};
            }
            if(r >= x1+a && r < x2 && c >= y1 && c < y1+a) {
                seq = seq + (a*a);
                cur = new int[]{x1 + a, x2, y1, y1 + a};
            }
            if(r >= x1 && r < x1+a && c >= y1 && c < y1+a){
                cur = new int[]{x1,x1+a,y1,y1+a};
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int r = Integer.parseInt(splitStr[1]);
        int c = Integer.parseInt(splitStr[2]);

        int size = 1;
        for(int i=0;i<n;i++)
            size*=2;

        System.out.println(Z(size,r,c));

    }
}
