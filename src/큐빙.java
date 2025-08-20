import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐빙 {

    static char[][][] cube;


    static void move(String str){

        char dir = str.charAt(0);
        char v = str.charAt(1);

        if(dir=='U'){

        }else if(dir=='D'){

        }else if(dir=='F'){

        }else if(dir=='B'){

        }else if(dir=='L'){

        }else if(dir=='R'){

        }



    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb= new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        while(t-->0){
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String[] str = new String[n];
            for(int i=0;i<n;i++){
                str[i] = st.nextToken();
            }




        }

    }
}
