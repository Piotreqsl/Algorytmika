
// We have 2 strings ACTGACG and TGACGAC if we move indexes of the second one forward n times,
// then it should be the same as first one
public class CircularRotation {
    public static boolean isCircularRotation(String s, String t){
        //declaring necessary variables
        int lenS = s.length();
        int lenT = t.length();
        char[] arrT = t.toCharArray();

        //Below some basic checks to prevent useless calculations
        if(lenS != lenT) return false;
        if(s.equals(t)) return true;
        if(lenS == 0 || lenT ==0) return false;
        if(s.equals(null) || t.equals(null)) return false;

        //Main loop that holds variable "numberForward" which stands for how many should we
        //add to the index. It checks through all the combinations
        for (int numberForward = 0; numberForward < lenS ; numberForward++) {

            char[] newArr = new char[lenT];//temporary array to hold our new string combined of increased indexes
            for(int mainIndex =0; mainIndex < lenT ; mainIndex++)//nested loop that stands for our string indexes
                                                                 // to go through one by one
            {
                newArr[(numberForward + mainIndex) % lenT] = arrT[mainIndex];
                //the most important moment of calculating index in new array
                //firstly it calculates sum of number we want to add and index of char in main array
                //then rest of divide by length
                //to explain lets take a look at word "cat"
                // and move it 2 indexes forward (numberForward will be 2, lenT =3)
                //1st iteration newArr[ (2+0)%3 = 2] = 'c' // Our new array is {'', '', 'c'}
                //2nd iteration newArr[ (2+1)%3 = 0] = 'a' // Our new array is {'a', '', 'c'}
                //3rd iteration newArr[ (2+1)%3 = 1] = 't' // Our new array is {'a', 't', 'c'}
                //In this way it will never throw an error Out of Bound
            }
            if(String.valueOf(newArr).equals(s)) return true; // if our newly created string matches first,
                                                              // return true, else proceed
        }
        return  false; //default return if not matched in above loop
    }




    public static void main(String[] args) {
        System.out.println(isCircularRotation("ACTGACG", "TGACGAC"));
    }
}
