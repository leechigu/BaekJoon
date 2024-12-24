import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴 {

/*    static int[] a;
    static int[] b;
    static int[] c;
    static int[] d;*/

    static String a;
    static String b;
    static String c;
    static String d;

    static boolean bool1;
    static boolean bool2;
    static boolean bool3;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        c = br.readLine();
        d = br.readLine();

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            move(num,dir);
        }

        int answer = 0;
        if(a.charAt(0)=='1')
            answer+=1;
        if(b.charAt(0)=='1')
            answer+=2;
        if(c.charAt(0)=='1')
            answer+=4;
        if(d.charAt(0)=='1')
            answer+=8;

        System.out.println(answer);

    }

    public static String rotation(String cur, int dir){
        String rtn = null;
        if(dir==-1){
            rtn = cur.substring(1)+cur.charAt(0);
        }else if(dir==1){
            rtn = cur.charAt(cur.length()-1)+cur.substring(0,cur.length()-1);
        }
        return rtn;
    }
    public static void checkAll(){
        bool1 = a.charAt(2) == b.charAt(6);
        bool2 = b.charAt(2) == c.charAt(6);
        bool3 = c.charAt(2) == d.charAt(6);
    }

    public static void move(int num, int dir){

        checkAll();
        if(num==1){
            a=rotation(a,dir);
            if(bool1){

            }else{
                b=rotation(b,dir*-1);
                if(bool2){
                }else{
                    c=rotation(c,dir);
                    if (bool3) {
                    }else{
                        d=rotation(d,dir*-1);
                    }
                }
            }
        }else if(num==2){
            b=rotation(b,dir);
            if(bool1){
            }else{
                a=rotation(a,dir*-1);
            }
            if(bool2){
            }else{
                c=rotation(c,dir*-1);
                if(bool3){
                }else{
                    d=rotation(d,dir);
                }
            }
        }else if(num==3){
            c=rotation(c,dir);
            if(bool3){
            }else{
                d=rotation(d,dir*-1);
            }
            if(bool2){

            }else{
                b=rotation(b,dir*-1);
                if(bool1){
                }else{
                    a=rotation(a,dir);
                }
            }
        }else if(num==4){
            d=rotation(d,dir);
            if(bool3){
            }else{
                c=rotation(c,dir*-1);
                if(bool2){
                }else{
                    b=rotation(b,dir);
                    if (bool1) {
                    }else{
                        a=rotation(a,dir*-1);
                    }
                }
            }
        }
    }

}
