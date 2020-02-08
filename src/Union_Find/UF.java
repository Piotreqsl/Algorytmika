package Union_Find;

public class UF {
    private int[] id; // Array, that holds dot indexes, N-size
    private int count; //number of separate connected pairs, initially must be N, because there are N single dots.

    public UF(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++ ){
            id[i] = i; //Populating id array [1,2,3,...,N]
        }
    }

    public int count() {return count;}

    public boolean connected(int p, int q) {return find(p) == find(q);}

    public int find(int p) { return id[p]; }

    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);

        //We don't need to do anything as long as pID is the same as qID, so they are connected
        if(pID == qID) return;

        for (int i =0; i < id.length; i++)
        {
            //Change every dot that is connected with p to q so they are connected now
            //It can also be vice-versa, we can change every q to p, doesn't matter.
            if(id[i] == pID) id[i] = qID;
        }


    }
}
