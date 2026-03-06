import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마법사상어와파이어볼 {

    static int[][] pos = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    static int n,m,k;
    static Map<String, List<int[]>> map = new HashMap<>();

    static void move(){
        Map<String, List<int[]>> nextMap = new HashMap<>();
        for(String key : map.keySet()){
            List<int[]> list = map.get(key);
            String[] splitStr = key.split(",");
            int y = Integer.parseInt(splitStr[0]);
            int x = Integer.parseInt(splitStr[1]);

            for(int[] fire : list){

                int val  = fire[0];
                int s = fire[1];
                int d = fire[2];

                int nextY = y + s*pos[d][0];
                int nextX = x + s*pos[d][1];

                nextY%=n;
                nextX%=n;

                if(nextY<0)
                    nextY+=n;
                if(nextX<0)
                    nextX+=n;

                String nextKey = nextY+","+nextX;

                if(!nextMap.containsKey(nextKey)){
                    List<int[]> nextList = new ArrayList<>();
                    nextList.add(new int[]{val,s,d});
                    nextMap.put(nextKey,nextList);
                }else{
                    nextMap.get(nextKey).add(new int[] {val,s,d});
                }
            }
        }

        map.clear();


        for(String key : nextMap.keySet()){

            List<int[]> list = nextMap.get(key);
            if(list.size()<=1){
                if(!map.containsKey(key)){
                    map.put(key,list);
                }else{
                    map.get(key).add(list.get(0));
                }
                continue;
            }

            int valSum =0;
            int sSum = 0;
            int curD = list.get(0)[2];

            boolean isSame = true;

            for(int[] fire : list){
                valSum += fire[0];
                sSum += fire[1];
                if(isSame){
                    if(fire[2]%2==0) {
                        if (curD % 2 != 0) {
                            isSame = false;
                        }
                    }else{
                        if(curD %2==0){
                            isSame = false;
                        }
                    }
                    curD = fire[2];
                }
            }
            int nextVal = valSum/5;
            int nextS = sSum/list.size();
            if(nextVal==0){
                continue;
            }
            if(isSame){
                for(int i=0;i<8;i+=2){
                    if(!map.containsKey(key)){
                        List<int[]> nextList = new ArrayList<>();
                        nextList.add(new int[]{nextVal,nextS,i});
                        map.put(key,nextList);
                    }else{
                        map.get(key).add(new int[] {nextVal,nextS,i});
                    }
                }

            }else{
                for(int i=1;i<8;i+=2){
                    if(!map.containsKey(key)){
                        List<int[]> nextList = new ArrayList<>();
                        nextList.add(new int[]{nextVal,nextS,i});
                        map.put(key,nextList);
                    }else{
                        map.get(key).add(new int[] {nextVal,nextS,i});
                    }
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            String key = r+","+c;
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{m,s,d});
            map.put(key,list);
        }

        for(int i=0;i<k;i++){
            move();
        }

        int answer =0;

        for(String key : map.keySet()){
            for(int[] fire : map.get(key)){
                answer+=fire[0];
            }
        }
        System.out.print(answer);
    }
}
