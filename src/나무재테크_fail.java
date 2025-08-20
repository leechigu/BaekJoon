import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나무재테크_fail {

    static int[][] a;
    static int[][] map;
    static int n,m,k;

    static int[][] pos = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    static Map<String, List<Integer>> tree = new HashMap<>();

    static int treeCnt=0;

    static void go(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String key = i+","+j;
                if(tree.containsKey(key)){
                    List<Integer> list = tree.get(key);
                    List<Integer> newList = new ArrayList<>();
                    List<Integer> deadList = new ArrayList<>();
                    Collections.sort(list);
                    for(int age : list){
                        if(map[i][j]>=age) {
                            map[i][j] -= age;
                            newList.add((age+1));
                        }else{
                            deadList.add(age);
                        }
                    }
                    tree.put(key,newList);
                    treeCnt -= deadList.size();
                    for(int deadAge : deadList){
                        map[i][j] += deadAge/2;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String key = i+","+j;
                if(tree.containsKey(key)){
                    List<Integer> list = tree.get(key);
                    for(int age :  list){
                        if (age >= 5 && age % 5 == 0) {
                            for(int k=0;k<8;k++) {
                                int nextY = i + pos[k][0];
                                int nextX = j + pos[k][1];
                                if (nextY < 0 || nextY >= n) continue;
                                if (nextX < 0 || nextX >= n) continue;

                                String nextKey = nextY + "," + nextX;

                                if (tree.containsKey(nextKey)) {
                                    tree.get(nextKey).add(1);
                                } else {
                                    List<Integer> nextList = new ArrayList<>();
                                    nextList.add(1);
                                    tree.put(nextKey, nextList);
                                }
                                treeCnt++;
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] += a[i][j];
            }
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        map = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(map[i],5);
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        treeCnt = m;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            String key = x+","+y;
            if(tree.containsKey(key)){
                tree.get(key).add(z);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(z);
                tree.put(key,list);
            }
        }
        for(int i=0;i<k;i++){
            go();
        }
        System.out.print(treeCnt);
    }
}
