import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 사전순최대공통부분수열_FAIL {

    public static int n;
    public static int m;
    public static ArrayList<Integer> array1;
    public static ArrayList<Integer> array2;
    public static HashSet<String> hashSet = new HashSet<>();

    public static void recursive(ArrayList<Integer> arrayList,int a,int b){


        for(int i=a;i<n;i++){
            for(int j=b;j<m;j++){
                if(array1.get(i)==array2.get(j)){
                    hashSet.add(arrayList.toString().substring(1,arrayList.toString().length()-1));
                    recursive(arrayList,i+1,0);

                    arrayList.add(array1.get(i));
                    hashSet.add(arrayList.toString().substring(1,arrayList.toString().length()-1));
                    int indx = arrayList.size()-1;
                    recursive(arrayList,i+1,j+1);
                    arrayList.remove(indx);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        array1 = new ArrayList<>();

        for(int i=0;i<n;i++){
            array1.add(Integer.valueOf(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        array2 = new ArrayList<>();
        for(int i=0;i<m;i++){
            array2.add(Integer.valueOf(st.nextToken()));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        recursive(arrayList,0,0);

        ArrayList<String> answer = new ArrayList<>();

        for(String a: hashSet){
            answer.add(a);
        }
        Collections.sort(answer);

        System.out.println(answer.get(answer.size()-1));

    }
}
