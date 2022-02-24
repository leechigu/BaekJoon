import java.util.*;
public class 단어정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> hash = new HashSet<>();
        for(int i=0;i<n;i++)
            hash.add(sc.next());
        Iterator<String> it = hash.iterator();
        String[] st = new String[hash.size()];
        int count=0;
        while(it.hasNext()){
            st[count]= it.next();
            count++;
        }
        Arrays.sort(st, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length())
                    return o1.compareTo(o2);
                else
                   return o1.length()-o2.length();
            }
        });
        for(int i=0;i<st.length;i++)
            System.out.println(st[i]);
    }
}
