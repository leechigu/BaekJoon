import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나무재테크 {

    static int[][] map;
    static int[][] next;
    static Deque<Integer>[][] treeInfo;
    static int n;

    static int[][] pos = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    static void eatOrDie(){

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Deque<Integer> queue = treeInfo[i][j];
                Deque<Integer> newQueue = new ArrayDeque<>();
                int oldSum = 0;
                for(int treeAge : queue){
                    if(treeAge<=map[i][j]){
                        map[i][j] -= treeAge;
                        newQueue.addLast(treeAge+1);
                    }else{
                        oldSum += treeAge/2;
                    }
                }
                treeInfo[i][j] = newQueue;
                map[i][j] += oldSum;
            }
        }
    }

    static void addTree(int y,int x){
        for(int i=0;i<pos.length;i++){
            int nextY = y + pos[i][0];
            int nextX = x + pos[i][1];

            if(nextY<0|| nextY>=n)
                continue;
            if(nextX<0|| nextX>=n)
                continue;
            treeInfo[nextY][nextX].addFirst(1);
        }
    }

    static void autumn(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Deque<Integer> queue = treeInfo[i][j];
                for(int treeAge : queue){
                    if(treeAge%5==0){
                        addTree(i,j);
                    }
                }
            }
        }
    }

    static void winter(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] += next[i][j];
            }
        }
    }

    static void process(){
        eatOrDie();
        autumn();
        winter();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        treeInfo = new Deque[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                treeInfo[i][j] = new ArrayDeque<>();
            }
        }

        map = new int[n][n];
        next = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(map[i],5);
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                next[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            treeInfo[x][y].add(z);
        }

        for(int i=0;i<k;i++){
            process();
        }

        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer +=treeInfo[i][j].size();
            }
        }

        System.out.print(answer);

    }
}
