import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 괄호추가하기 {

    static int max = Integer.MIN_VALUE;



    static void process(List<Integer> nums, List<Character> opes, int cnt){

        if(cnt==0){
            max = Math.max(nums.get(0),max);
            return;
        }

        for(int i=0;i<cnt;i++){
            int a = nums.remove(i);
            int b = nums.remove(i);
            char operator = opes.remove(i);
            int cal = calculate(a,b,operator);
            nums.add(i,cal);

            System.out.println("cal = "+cal);
            System.out.println(nums.toString());
            System.out.println(opes.toString());

            process(nums,opes,cnt-1);

            opes.add(i,operator);
            nums.remove(i);
            nums.add(i,b);
            nums.add(i,a);
        }
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

        process(nums,opes,opes.size());

        System.out.println(max);

    }
}
