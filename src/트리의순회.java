
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리의순회 {

    static StringBuilder sb =new StringBuilder();
    static int[] inOrder;
    static int[] postOrder;

    public static void search(int stA,int edA,int stB,int edB){
        //b의 맨 마지막 친구는 root
        int root = postOrder[edB];
        int indx = -1;
        for(int i=stA;i<=edA;i++){
            if(inOrder[i] == root) {
                indx = i;
                break;
            }
        }

        sb.append(root).append(" ");

        if(indx!=-1) {
            int curSize = edA-stA;
            int leftSize = indx-stA;
            int rightSize = curSize-leftSize;

            if (indx != stA) {
                search(stA, indx - 1,stB, stB+leftSize-1);
            }
            if (indx != edA) {
                search(indx + 1, edA, edB-1-(rightSize-1),edB-1);
            }
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        search(0,n-1,0,n-1);

        System.out.print(sb.toString());

    }
}
