package Union_Find;

public class UF_Quick_Union {
    private int[] id; // Array, that holds dot indexes, N-size
    private int count; //number of separate connected pairs, initially must be N, because there are N single dots.

    public UF_Quick_Union(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++ ){
            id[i] = i; //Populating id array [1,2,3,...,N]
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
        int pRoot = find(p);
        int qRoot = find(q);

        //Roots are identical, so no need to change root
        if(pRoot == qRoot) return;

        //Change root of p to root of q (root of element can be this element)
        //(It might refer to its own)
        //It can be vice-versa too
        id[pRoot] = qRoot;

        count--;
    }
}