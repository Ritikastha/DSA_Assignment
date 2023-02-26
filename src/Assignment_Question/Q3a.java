package Assignment_Question;

public class Q3a {
// this method takes an array of integers and calculates the product of all elements in the array
    public static int Product(int[] subaaray){
        if (subaaray.length == 0){
            return 0;
        }
        int res = 1;
        for (int i = 0;i<subaaray.length;i++){
            res = res*subaaray[i];
        }
        return res;
    }

//    Accepts an integer array and determines the smallest difference between the products of two equal-length subarrays
    public static int find_min_difference(int[] array){
        int mindiff = Integer.MAX_VALUE;
        int n = array.length;
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == n / 2) {
                int[] subarray1 = new int[n / 2];
                int[] subarray2 = new int[n / 2];
                int index1 = 0;
                int index2 = 0;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        subarray1[index1++] = array[j];
                    } else {
                        subarray2[index2++] = array[j];
                    }
                }
                int subarray1product = Product(subarray1);
                int subarray2product = Product(subarray2);
                int curr_min_diff = 0;
                if (subarray2product>subarray1product){
                    curr_min_diff = subarray2product-subarray1product;
                }else{
                    curr_min_diff = subarray1product-subarray2product;
                }
                if (curr_min_diff<mindiff){
                    mindiff = curr_min_diff;
                }

            }
        }
//        return minimum diffrence
        return mindiff;


    }


    public static void main(String[] args) {
        int[] array = {5, 2, 4, 11};
        int answer = find_min_difference(array);
        System.out.println(answer);

    }
}


