package Assignment_Question;

/*
Question 8b)
        Given an array of even numbers sorted in ascending order and an integer k,
        Find the k^th missing even number from provided array
        Input a[] ={0, 2, 6, 18, 22} k=6
        Output: 16 examples:
        Explanation: Missing even numbers on the list are 4, 8, 10, 12, 14, 16, 20 and so on
        and kth missing number is on 6th place of the list i.e. 16
*/

import java.util.ArrayList;
        import java.util.List;

class Missing_Even {
//    method declaration for finding the kth missing even number
    public static int find_Kth_MissingEvenNumber(int[] a, int k) {
//        creates an ArrayList to store the missing even numbers
        List<Integer> missingEvens = new ArrayList<>();
//        initialize
        int j = 0;
        int i = a[0];
//        starts a loop that will continue until k missing even numbers have been found.
        while (missingEvens.size() < k) {
//            determines if the input array a contains the current even number i
//            if true then j is incremented
            if (j < a.length && a[j] == i) {
                j++;
            }
//         list of missing even numbers is expanded if the current even number i is not found in the input array a.
            else {
                missingEvens.add(i);
            }
//            increments i by 2
            i += 2;
        }
//        returns the kth missing even number from list of missing even numbers.
        return missingEvens.get(k - 1);
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 6, 18, 22};
        int k = 6;
        System.out.println(find_Kth_MissingEvenNumber(a, k));
    }
}

