import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최대힙 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2-o1);
            }
        });
        for(int i=0;i<n;i++){
            input = br.readLine();
            int x = Integer.parseInt(input);
            if(x==0){
                if(heap.isEmpty()){
                    System.out.println(0);
                }else {
                    Integer minVal = heap.poll();
                    System.out.println(minVal);
                }
            }else if(x!=0){
                heap.add(x);
            }
        }
    }
}
