import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();



        while(true){

            if(l>100){
                System.out.println(-1);
                return;
            }
            if(l%2==1) {
                long skajwl = n % l;
                long x = n / l;

                if(skajwl!=0){
                    l++;
                }else{
                    int a = l/2;

                    if(x+(a*-1)<0){
                        l++;
                        continue;
                    }

                    for(int i=a*-1;i<=a;i++){
                        sb.append(x+i).append(" ");
                    }
                    break;
                }
            }else{

                int temp = l/2;

                long skajwl = n % temp;
                long x = n/temp;

                if(skajwl==0&&x%2==1){

                    long a = x/2;
                    int start = l/2 * - 1 + 1;
                    int end = l/2;

                    if(start+a<0){
                        l++;
                        continue;
                    }
                    for(int i = start;i<=end;i++){
                        sb.append(a+i).append(" ");
                    }

                    break;
                }else{
                    l++;
                }

            }



        }




        System.out.print(sb);

    }
}
