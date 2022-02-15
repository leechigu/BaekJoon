import java.util.*;

public class 회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr1 = new int[n][2];
        for(int i=0;i<n;i++){
            arr1[i][0] = sc.nextInt();
            arr1[i][1] = sc.nextInt();
        }
        Arrays.sort(arr1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int ed=-1;
        int count =0;
        for(int i=0;i<n;i++){
            if(arr1[i][0]>=ed){
                ed = arr1[i][1];
                count++;
            }
        }
        System.out.print(count);
    }
}
