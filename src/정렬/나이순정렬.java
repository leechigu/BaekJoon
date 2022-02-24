package 정렬;

import java.util.*;

public class 나이순정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] person = new String[n][2];
        for(int i=0;i<n;i++){
            person[i][0] = sc.next();
            person[i][1] = sc.next();
        }
        Arrays.sort(person, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0]==o2[0]){
                    return 0;
                }
                else{
                    return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
                }
            }
        });
        for(int i=0;i<n;i++){
            System.out.println(person[i][0]+" "+person[i][1]);
        }
    }
}
