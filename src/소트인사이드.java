import java.util.Arrays;
import java.util.Scanner;

public class 소트인사이드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        StringBuffer string = new StringBuffer(number);

        int[] n = new int[string.length()];
        for(int i= 0; i<n.length;i++) {
            char temp = string.charAt(i);
            n[i] = temp - 48;

        }
        Arrays.sort(n);
        for(int i =0;i<n.length;i++){
            System.out.print(n[n.length-1-i]);
        }
    }

}
