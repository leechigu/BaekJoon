import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 나무자르기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);


        Integer[] arr = new Integer[n];
        input = br.readLine();
        splitStr = input.split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(splitStr[i]);
        }


        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2-o1);
            }
        });

        int max = arr[0];
        int min = 0;
        int mid = (max+min)/2;

        while(true){

            if(max<min)
                break;

            long sum = 0;
            boolean isPossible = false;

            for(int i=0;i<arr.length;i++){
                if(arr[i]>mid){
                    sum+=(arr[i]-mid);
                }
                if(sum>=m) {
                    isPossible = true;
                    break;
                }
            }

            if(isPossible){
                min = mid+1;
                mid = (max+min)/2;
            }else{
                max = mid-1;
                mid = (max+min)/2;
            }
        }

        System.out.println(mid);

    }
}
