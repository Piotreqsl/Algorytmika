package Union_Find;

public class WeightedQuickUnionUF {
    private int[] id; // Array, that holds dot indexes, N-size
    private int[] sz; // Trees depths, based on indexes
    private int count; //number of separate connected pairs, initially must be N, because there are N single dots.

    public WeightedQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++ ){
            id[i] = i; //Populating id array [1,2,3,...,N]
        }

        sz = new int[N];
        for (int i = 0; i< N; i++) {
            sz[i] = 1; //Initially every element is a tree with depth 1.
        }
    }

    public int count() {return count;}

    public boolean connected(int p, int q) {return find(p) == find(q);}

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);

        //Roots are identical, so no need to change root
        if(i == j) return;

        //Setting smaller root, so it leads to the bigger one
        if (sz[i] < sz[j]){
            id[i] = j; // Set root as previously
            sz[j] += sz[i]; //Increment size array by the size of smaller root
        }
        else{
            id[j] = i; // Set root as previously
            sz[i] += sz[j]; //Increment size array by the size of smaller root
        }
        count--;
    }
}