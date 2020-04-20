package Data_Structures;

public class PriorityQueue<Key extends  Comparable<Key>> {
    private  Key[] pq;
    private int N = 0;

    public PriorityQueue(int maxN){
        pq = (Key[]) new Comparable[maxN +1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size()
    {return N;}

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1]; //Getting max key from root
        exch(1, N--); //swapping with last element
        pq[N+1] = null; // Avoiding unnecessary references
        sink(1); // restoring heap structure
        return max;
    }

    private void swim(int k){
        while (k >1 && less(k/2 ,k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(k,j);
            k =j;
        }
    }

    private boolean less(int i, int j)
    {return pq[i].compareTo(pq[j]) < 0;}

    private void exch(int i, int j)
    {Key t = pq[i]; pq[i] = pq[j]; pq[j]= t;}
}
