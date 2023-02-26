package Assignment_Ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Question 3
//        a)
//        You are given an even length array; divide it in half and return possible minimum product difference
//        of any two subarrays.
//        Note that the minimal product difference is the smallest absolute difference between any two arrays
//        a and b, which is computed by calculating the difference after multiplying each element of the arrays
//        a and b.
//        Input: {5,2,4,11}
//        Output: 2
//        {5,4} {2,11} result into minimum product difference.

public class Q3a {
        public static List<int[]> find_S_Arrays(int[] arr) {
            List<int[]> subArr = new ArrayList<>();
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int len = j - i + 1;
                    int[] sub_array = new int[len];
                    for (int k = 0; k < len; k++) {
                        sub_array[k] = arr[i + k];
                    }
                    subArr.add(sub_array);
                }
            }
            return subArr;
        }
        public static void main(String[] args) {
            int[] arr = new int[]{5,4,2,11};
            List<int[]> sub_arrays = find_S_Arrays(arr);
            int lenght = sub_arrays.size();
            int[] product_Array = new int[lenght];
            int i = 0;
            for (int[] arrP : sub_arrays) {
                int product = 1;
                for (int element : arrP) {
                    product *= element;
                }
                product_Array[i] = product;
                i++;
            }
            Arrays.sort(product_Array);
            System.out.println(Arrays.toString(product_Array));
            int minDiff = product_Array[1]- product_Array[0];
            for (int j = 2; j < product_Array.length ; j++) {
                minDiff = Math.min(minDiff, product_Array[j]- product_Array[j-1]);
            }
            System.out.println(minDiff);
        }

    }


