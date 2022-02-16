import java.util.*;


class Graph{
    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean isVisited;
        Node(int data){
            this.data = data;
            this.isVisited = false;
            adjacent = new LinkedList<Node>();
        }
    }
    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        for(int i=0;i<size;i++){
            nodes[i] = new Node(i);
        }
    }
    void addEdge(int i1,int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
    }

    void dfs(int index){
        Node root = nodes[index];
        Stack<Node>stack = new Stack<Node>();
        stack.push(root);
        root.isVisited = true;
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for(Node n : r.adjacent){
                if(n.isVisited == false){
                    n.isVisited = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
        System.out.println();
    }
    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.isVisited =true;
        while(!queue.isEmpty()){
            Node r = queue.poll();
            for(Node n : r.adjacent){
                if(n.isVisited ==false){
                    n.isVisited = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }
    void visit(Node n){
        System.out.print(n.data+1 + " ");
    }
}

public class DFS와BFS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n,m,v;
        n= sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt()-1;
        int e1,e2;
        Graph graph1 = new Graph(n);
        Graph graph2 = new Graph(n);


        int[][] arr = new int[m][2];


        for(int i=0;i<m;i++){
            e1=sc.nextInt()-1;e2 =sc.nextInt()-1;
            arr[i][0] = e1;
            arr[i][1] = e2;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return o2[0]-o1[0];
                }
                else{
                    return o1[1]-o2[1];
                }

            }
        });
        for(int i=0;i<m;i++){
            graph1.addEdge(arr[i][0],arr[i][1]);
            graph2.addEdge(arr[i][0],arr[i][1]);
        }
        graph1.dfs(v);
        graph2.bfs(v);
    }

}
