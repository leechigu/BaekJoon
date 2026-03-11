import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 괄호추가하기_re {

    static int max = Integer.MIN_VALUE;

    static void process(List<Integer> nums, List<Character> opes,int st){

        max = Math.max(calculate(nums,opes),max);

        int size = opes.size();

        for(int i=st;i<size;i++){
            int a = nums.remove(i);
            int b = nums.remove(i);
            char operator = opes.remove(i);
            int cal = calculate(a,b,operator);
            nums.add(i,cal);

            process(nums,opes,i+1);
            opes.add(i,operator);
            nums.remove(i);
            nums.add(i,b);
            nums.add(i,a);
        }
    }

    static int calculate(List<Integer> nums, List<Character> opes){

        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Character> opeDeque = new ArrayDeque<>();

        for(int num : nums){
            deque.addLast(num);
        }
        for(char ope : opes){
            opeDeque.addLast(ope);
        }

        while(!opeDeque.isEmpty()){
            char ope = opeDeque.pop();
            int a = deque.pop();
            int b = deque.pop();
            if (ope == '+') {
                deque.addFirst(a+b);
            }
            else if(ope=='*'){
                deque.addFirst(a*b);
            }else if(ope=='-'){
                deque.addFirst(a-b);
            }
        }
        return deque.pop();
    }


    static int calculate(int a, int b, char operator){
        if(operator=='*'){
            return a*b;
        }else if(operator=='-'){
            return a-b;
        }else if(operator=='+'){
            return a+b;
        }else{
            return 0;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        List<Integer> nums = new ArrayList<>();
        List<Character> opes = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i%2==0){
                nums.add(str.charAt(i)-'0');
            }else{
                opes.add(str.charAt(i));
            }
        }
        process(nums,opes,0);
        System.out.print(max);


    }
}
