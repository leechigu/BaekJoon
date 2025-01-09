import javax.security.auth.callback.CallbackHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호의값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        int curVal = 1;
        int answer = 0;

        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(c=='('){
                curVal*=2;
                stack.add(c);
            }else if(c=='['){
                curVal*=3;
                stack.add(c);
            }
            if(c==')'){
                if(stack.isEmpty()){
                    System.out.println(0);
                    return;
                }else{
                    char p = stack.peek();
                    if(p=='('){
                        if(chars[i-1]=='(')
                            answer+=curVal;
                        stack.pop();
                        curVal/=2;
                    }else{
                        System.out.println(0);
                        return;
                    }
                }
            }else if(c==']'){
                if(stack.isEmpty()){
                    System.out.println(0);
                    return;
                }else{
                    char p = stack.peek();
                    if(p=='['){
                        if(chars[i-1]=='[')
                            answer+=curVal;
                        stack.pop();
                        curVal/=3;
                    }else{
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        if(stack.isEmpty())
            System.out.println(answer);
        else
            System.out.println(0);
    }
}
