package Sort;

public class QuickSort {

    public static void sort(Comparable[] a)
    {
        ///shuffle
        sort(a, 0, a.length -1);
    }

    public static void sort (Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }



    private static int partition(Comparable[] a, int lo, int hi)
    { //Separation for a[lo..i-1], a[i], a[i+1..h1].
        int i = lo, j = hi + 1; // left and right index to lookup table
        Comparable v = a[lo]; //Anchor element

        while (true)
        {   // Checking on right, checking on left, check if lookup is ended, and swap
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); //Placing v = a[j] in correct position
        return j; // so a[lo...j-1] <= [j] <= a[j+1...h1]
    }


    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0;}

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
}
