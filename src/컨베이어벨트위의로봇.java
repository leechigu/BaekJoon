import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {

    public static List<Integer> belt = new ArrayList<>();
    public static List<Integer> robot = new ArrayList<>();
    public static int n;
    public static int cnt = 0;
    public static int k;

    public static void rotate(){

        int last = belt.remove(2*n-1);
        belt.add(0,last);
        for(int i=0;i<robot.size();i++){
            int pos = robot.get(i);
            pos++;
            if(pos==n-1){
                robot.remove(i);
                i--;
                continue;
            }
            robot.set(i,pos);
        }
    }

    public static void moveRobot(){

        for(int i=0;i<robot.size();i++){
            int next = robot.get(i)+1;
            if(belt.get(next)>0 && !robot.contains(next)){
                belt.set(next,belt.get(next)-1);
                if(belt.get(next)==0){
                    cnt++;
                }
                if(next==n-1){
                    robot.remove(i);
                    i--;
                    continue;
                }
                robot.set(i,next);
            }
        }
    }

    public static void putRobot(){
        int beltState = belt.get(0);
        if(beltState>0){
            robot.add(0);
            belt.set(0,beltState-1);
            if(beltState-1==0){
                cnt++;
            }
        }
    }

    public static int process(){
        int answer =1;
        while(true){
            rotate();
            moveRobot();
            putRobot();
            if(cnt>=k){
                break;
            }
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*n;i++){
            belt.add(Integer.parseInt(st.nextToken()));
        }
        System.out.print(process());
    }
}
