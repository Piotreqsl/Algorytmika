

public class BinarySearch {

    public static int rank(int key, int[] a)
    {   // Array must be sorted!
        int lo = 0;
        int hi = a.length -1;
        while(lo <= hi)
        {   // Key is within a[lo..hi] or it is not present
            int mid = lo + (hi -lo) /2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid +1;
            else return  mid;
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] test = {1,4,8,12,15,17};
        System.out.println(rank(1, test));


    }
}
