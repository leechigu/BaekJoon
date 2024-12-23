import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 휴게소세우기 {

    static int m;
    static ArrayList<Integer> lenList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arrList = new ArrayList<>();
        lenList = new ArrayList<>();

        arrList.add(0);
        arrList.add(l);

        for(int i=0;i<n;i++){
            arrList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrList);

        for(int i=0;i<arrList.size()-1;i++){
            int len  = arrList.get(i+1)-arrList.get(i);
            lenList.add(len);
        }

        Collections.sort(lenList);

        //이분 탐색으로 접근
        int max = lenList.get(lenList.size()-1);
        int min = 1;
        int mid = (max+min)/2;
        while(min<max){

            //System.out.println(min + " "+ mid + " "+ max);
            //System.out.println(check(mid));
            if(!check(mid)){
                min = mid+1;
                mid = (min+max)/2;
            }else{
                max = mid;
                mid = (min+max)/2;
            }
        }
        System.out.println(mid);
    }

    static boolean check(int mid){

        boolean isPossible = true;
        int cnt = 0;

        for(int len : lenList){

            if(len > mid) {
                if (len % mid == 0)
                    cnt += len / mid-1;
                else
                    cnt += len / mid;
            }

            if(cnt>m) {
                isPossible = false;
                break;
            }

        }

        return isPossible;
    }

}
