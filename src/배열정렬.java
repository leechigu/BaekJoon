import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 배열정렬 {

    static String str;
    static List<int[]> list;
    static Map<String,Integer> map = new HashMap<>();
    static String target;

    static class M implements Comparable<M>{
        int a;
        int b;
        int val;
        String num;

        M(int a,int b,int val, String num){
            this.a = a;
            this.b = b;
            this.val = val;
            this.num = num;
        }

        @Override
        public int compareTo(M o) {
            return Integer.compare(this.val,o.val);
        }
    }


    static String change(int a,int b, String num){
        char[] temp = num.toCharArray();
        char x = temp[a-1];
        char y = temp[b-1];
        temp[a-1] = y;
        temp[b-1] = x;
        return new String(temp);
    }

    static int bfs(){

        Queue<M> queue = new PriorityQueue<>();
        for(int [] temp : list){
            int a = temp[0];
            int b = temp[1];
            int val = temp[2];
            queue.add(new M(a,b,val,str));
        }

        while(!queue.isEmpty()){
            M poll = queue.poll();

            int a = poll.a;
            int b = poll.b;
            int val = poll.val;
            String num = poll.num;

            String nextNum = change(a,b,num);
            if(nextNum.equals(target)){
                return val;
            }else{
                //문자열 체크
                if(map.containsKey(nextNum)){
                    if(map.get(nextNum)<=val){
                        continue;
                    }else{
                        map.put(nextNum,val);
                    }
                }else{
                    map.put(nextNum,val);
                }
            }

            for(int [] temp : list){
                int nextA = temp[0];
                int nextB = temp[1];
                int nextVal = temp[2];
                if(a==nextA && b == nextB){
                    continue;
                }
                queue.add(new M(nextA,nextB,nextVal+val,nextNum));
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = "";
        target = "";
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            String cur = st.nextToken();
            arr[i] = Integer.parseInt(cur)-1;
            str = str + (Integer.parseInt(cur) - 1);
        }

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            target = target + arr[i];
        }

        if(target.equals(str)){
            System.out.println(0);
            return;
        }

        int m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b,c});
        }
        System.out.print(bfs());

    }
}
