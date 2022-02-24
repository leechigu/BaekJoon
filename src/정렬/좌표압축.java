package 정렬;

import java.io.*;
import java.util.*;


public class 좌표압축  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] x = new int[n];
        String temp = br.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            x[i] = arr[i];
        }
        Arrays.sort(x);
        HashMap<Integer,Integer> map = new HashMap<>();
        int c =0;
        for(int i : x){
            if(!map.containsKey(i)) {
                map.put(i, c);
                c++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }
        for(int i=0;i<n;i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
