import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 후위표기식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(c>='A'&&c<='Z'){
                sb.append(c);
                continue;
            }
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty()){
                    if(stack.peek()=='(') {
                        stack.pop();
                        break;
                    }
                    else
                        sb.append(stack.pop());
                }
            }else if(c=='+'||c=='-'){
                while(!stack.isEmpty()){
                    Character peekC = stack.peek();
                    if(peekC=='+'||peekC=='-'||peekC=='*'||peekC=='/'){
                        sb.append(stack.pop());
                    }else{
                        break;
                    }
                }
                stack.push(c);
            }else if(c=='*'||c=='/'){
                while(!stack.isEmpty()){
                    Character peekC = stack.peek();
                    if(peekC=='*'||peekC=='/'){
                        sb.append(stack.pop());
                    }else{
                        break;
                    }
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }
}
