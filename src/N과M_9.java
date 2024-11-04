import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedArrayType;
import java.util.*;

public class N과M_9 {

    static HashSet<String> answer;

    public static void dfs(int[] arr,String rtn,boolean[] isVisited,int cur,int target){

        if(cur==target){
            answer.add(rtn);
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                int rtnLen = rtn.length();
                rtn = rtn + String.valueOf(arr[i])+" ";
                dfs(arr,rtn,isVisited,cur+1,target);
                rtn = rtn.substring(0,rtnLen);
                isVisited[i] = false;
            }
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        answer = new HashSet<>();

        String[] splitStr = input.split(" ");
        int n = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);
        splitStr = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(splitStr[i]);

        Arrays.sort(arr);
        boolean[] isVisited = new boolean[n];
        String rtn = "";
        dfs(arr,rtn,isVisited,0,m);

        StringBuilder sb = new StringBuilder();

        ArrayList<int[]> sortedArr = new ArrayList<>();
        for(String ans : answer){
            String[] s = ans.split(" ");
            int[] tempArr = new int[m];
            for(int i=0;i<m;i++){
                tempArr[i] = Integer.parseInt(s[i]);
            }
            sortedArr.add(tempArr);
        }

        Collections.sort(sortedArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i=0;i<o1.length;i++)
                    if(o1[i]!=o2[i])
                        return Integer.compare(o1[i],o2[i]);
                return 0;
            }
        });

        for(int[] ans : sortedArr){
            for(int i=0;i<ans.length;i++)
                sb.append(ans[i]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
