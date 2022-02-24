import java.io.*;
import java.util.*;

public class 큰수만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = st.nextToken();
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String x = o1+o2;
                String y=  o2+o1;
                return x.compareTo(y);
            }
        });
        for(int i=0;i<n;i++)
            System.out.println(nums[i]);
        String answer ="";
        for (int i = n-1; i >=0; i--)
            answer +=nums[i];
        StringBuffer sb = new StringBuffer(answer);
        if(sb.charAt(0)=='0')
            System.out.print('0');
        else
            System.out.print(answer);
    }
}
