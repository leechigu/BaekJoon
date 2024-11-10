import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N과M_15 {
    static int[] arr;
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> answerList;

    public static void dfs(ArrayList<Integer> list,int indx,int cur){

        if(cur == m){
            answerList.add(new ArrayList<>(list));
            return;
        }

        for(int i=indx;i<n;i++){
            list.add(arr[i]);
            dfs(list,i,cur+1);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answerList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<n;i++)
            hashSet.add(Integer.parseInt(st.nextToken()));

        arr = new int[hashSet.size()];
        int indx = 0;
        for(int a :  hashSet){
            arr[indx] = a;
            indx++;
        }

        Arrays.sort(arr);
        n = arr.length;

        dfs(new ArrayList<>(),0,0);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answerList.size();i++){
            ArrayList<Integer> integers = answerList.get(i);
            for(int a : integers)
                sb.append(a).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
