import java.util.*;
public class 수찾기_1920 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> tree = new TreeSet<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            tree.add(sc.nextInt());
        }

        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i] = tree.contains(sc.nextInt()) ? 1 : 0;
        }
        for(int i=0;i<m;i++){
            System.out.println(arr[i]);
        }
    }
}