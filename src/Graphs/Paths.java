package Graphs;

import Data_Structures.Stack;

public class Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s; /// wierzochołek żródłowy

    public Paths(Graph G, int s)
    {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        dfs(G, s);
    }

    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        for(int w: G.adj(v))
            if(!marked[w]) {edgeTo[w] = v ; dfs(G, w);}
    }

    public boolean hasPathTo(int w)
    {return marked[w];}

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x =v; x != s; x = edgeTo[x])
        {
            path.push(x);
        }
        path.push(s);
        return (Iterable<Integer>) path;
    }
}
