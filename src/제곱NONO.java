import java.util.*;

public class 제곱NONO {

    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int ans = sc.nextInt();
        ArrayList<Integer> sosu = new ArrayList<>();
        int sosuCnt=0;
        if(ans ==1){
            System.out.println(ans);
            return;
        }
        int[] arr = new int[ans+1];
        for(int i=2;i<=ans;i++){
            arr[i] = i;
        }

        for(int i=2;i<=ans;i++){
            if(arr[i]==0){
                continue;
            }
            for(int j=i+1;j<=ans;j+=i){
                arr[j]=0;
            }
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i]!=0)
                sosuCnt++;
        }
        System.out.println(sosuCnt);
    }
}
