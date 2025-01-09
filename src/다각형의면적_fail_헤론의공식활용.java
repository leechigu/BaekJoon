import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다각형의면적_fail_헤론의공식활용 {

    public static int[][] dots;

    public static double calLength(int[] dot1,int[] dot2){
        long a = dot1[0]-dot2[0];
        long b = dot1[1]-dot2[1];

        a = a*a;
        b = b*b;
        return Math.sqrt(a+b);
    }

    public static double calTriangle(int stIndx){

        int[] dot1 = dots[0];
        int[] dot2 = dots[stIndx+1];
        int[] dot3 = dots[stIndx+2];

        double a = calLength(dot1,dot2);
        double b = calLength(dot2,dot3);
        double c = calLength(dot1,dot3);

        //System.out.println(a+ " "+ b+ " "+ c);

        double s = (a+b+c)/2.0;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dots = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }

        double sum = 0;
        for(int i=0;i<n-2;i++){
            sum+=calTriangle(i);
        }
        System.out.println(Math.round(sum*10)/10.0);
    }
}
