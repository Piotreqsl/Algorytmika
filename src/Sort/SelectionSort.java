package Sort;

public class SelectionSort {

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i =0; i < N; i++)
        {//Swapping a[i] with smallest element from a[i+i...N]
            int min = i; //index of the smallest element
            for(int j =i; j < N; j++){
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }


    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0;}

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

    public static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void printFormatted(Comparable[] arr){
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + "    ");
        }
    }

    public static void printFormatted(Comparable[] arr, int i, int j ){

        System.out.print(" " +i + "  ");
        System.out.print(j + "    ");
        for(int a=0; a < arr.length; a++){
            System.out.print(arr[a] + "    ");
        }
    }

}
