import java.util.Scanner;

public class 대회or인턴 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b= sc.nextInt();
        int c = sc.nextInt();

        int a2 =a/2;

        if(c==0){
            System.out.println(Math.min(a2,b));
            return;
        }
        else{

            int teamNum = Math.min(a2,b);
            if(a%2==1){
                a--;
                c--;
            }
            c= c-(a-teamNum*2);
            c=c-(b-teamNum);
            if(c<=0){
                System.out.println(Math.min(a2,b));
                return;
            }
            while(true){
                if(c<=0){
                    System.out.println(teamNum);
                    return;
                }
                c -=3;
                teamNum--;

            }
        }
    }
}
