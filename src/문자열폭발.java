import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 문자열폭발 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        int len = bomb.length();
        char last = bomb.charAt(len-1);

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length();i++){

            char cur = str.charAt(i);
            stack.add(cur);

            if(stack.size()>=len && cur == last){
                int temp = len;
                while(temp-->0){
                    sb.append(stack.pop());
                }
                String checkStr = sb.reverse().toString();
                if(!checkStr.equals(bomb)){
                    for(int j=0;j<checkStr.length();j++){
                        stack.add(checkStr.charAt(j));
                    }
                }
                sb.delete(0,sb.length());
            }

        }

        if(stack.isEmpty()){
            System.out.print("FRULA");
        }else{
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.print(sb.reverse().toString());
        }


    }
}
