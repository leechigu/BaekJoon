import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lcs_실패 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int indxa = 0;
        int indxb = 0;

        String temp1 = "";

        for(int i=indxa;i<a.length();i++){
            char curA = a.charAt(i);
            for(int j=indxb;j<b.length();j++){
                char curB = b.charAt(j);
                System.out.println(i+" "+curA+" "+j+" "+curB);
                if(curA==curB){
                    indxb=j+1;
                    temp1+=curB;
                    break;
                }
            }
        }

        indxa = 0;
        indxb = 0;
        String temp2 = "";
        for(int i=indxb;i<b.length();i++){
            char curB = b.charAt(i);
            for(int j=indxa;j<a.length();j++){
                char curA = a.charAt(j);
                if(curA==curB){
                    indxa=j+1;
                    temp2+=curB;
                    break;
                }
            }
        }
        System.out.println(temp1+" "+temp2);
        System.out.println(Math.max(temp1.length(),temp2.length()));
    }
}
