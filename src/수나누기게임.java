import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수나누기게임 {
    static List<Integer> sosuList;
    public static List<Integer> getSosuList(){
        int max = 1000000;
        boolean[] isSosu = new boolean[max+1];
        Arrays.fill(isSosu,true);
        List<Integer> sosuList = new ArrayList<>();

        for(int i=2;i*i<=max;i++){
            if(isSosu[i]){
                for(int j=2;j*i<=max;j++){
                    isSosu[j*i] = false;
                }
            }
        }
        for(int i=2;i<=max;i++){
            if(isSosu[i])
                sosuList.add(i);
        }
        return sosuList;
    }

    public static HashSet<Integer> getQuotSet(int num){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<sosuList.size();i++){
            int sosu = sosuList.get(i);
            int cur = sosu;

            if(sosu>=num){
                break;
            }
            if(num%sosu==0){
                while(true){
                    if(num%cur==0) {
                        set.add(num/cur);
                        set.add(cur);
                        cur = cur*sosu;
                        if(cur==num)
                            break;
                    }else{
                        break;
                    }
                }
            }
        }
        return set;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        //sosuList = getSosuList();

        int[] arr = new int[n];
        int[] originArr = new int[n];
        boolean[] nums   = new boolean[1000001];
        int[] answer = new int[1000001];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            originArr[i] = arr[i];
            nums[arr[i]] = true;
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            for (int j = 2; j * cur <= 1000000; j++) {
                int x = j * cur;
                if (nums[x]) {
                    answer[cur]++;
                    answer[x]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            sb.append(answer[originArr[i]]).append(" ");
        }

        System.out.print(sb);

    }
}
