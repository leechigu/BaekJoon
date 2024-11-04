import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class N과M_5 {

    public static List<List<Integer>> arrayList = new ArrayList<>();


    public static void dfs(int[] arr,List<Integer> list,boolean[] isVisited,int cur,int target){

        if(cur==target){
            arrayList.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(isVisited[i])
                continue;
            isVisited[i] = true;
            list.add(arr[i]);
            dfs(arr,list,isVisited,cur+1,target);
            list.remove(list.size()-1);
            isVisited[i] = false;
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        boolean[] isVisited =  new boolean[n];
        List<Integer> temp = new ArrayList<>();
        dfs(arr,temp,isVisited,0,m);

        for (List<Integer> result : arrayList) {
            for (int num : result) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
