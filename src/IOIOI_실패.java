import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI_실패 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        sb.append("I");
        for(int i=0;i<n;i++){
            sb.append("OI");
        }

        String nStr = sb.toString();


        //System.out.println(nStr);

        int answer = 0;
        int startIndx = -1;
        String str = br.readLine();

        for(int i=0;i<m-nStr.length()+1;i++){
            String temp = str.substring(i,i+nStr.length());
            if(temp.equals(nStr)){
                startIndx = i;
                break;
            }
        }

        if(startIndx==-1){
            System.out.println(0);
            return;
        }


        String tempStr = nStr;
        int lastIndx = startIndx + nStr.length();

        //System.out.println(lastIndx +" "+str.charAt(lastIndx));
        //System.out.println(lastIndx-1 +" "+str.charAt(lastIndx-1));
        while(true){

            if(lastIndx+2>=str.length()){
                break;
            }

            String two = str.substring(lastIndx,lastIndx+2);

            //System.out.println(two);

            if("OI".equals(two)){
                answer++;
                lastIndx = lastIndx+2;
            }else{
                boolean isPossible = false;
                for(int i = lastIndx;i<m-nStr.length()+1;i++){
                    String temp = str.substring(i,i+nStr.length());
                    if(temp.equals(nStr)){
                        startIndx = i;
                        lastIndx = startIndx + nStr.length() - 1;
                        answer++;
                        isPossible = true;
                        break;
                    }
                }
                if(!isPossible)
                    break;
            }
        }


        System.out.println(answer+1);

    }
}
