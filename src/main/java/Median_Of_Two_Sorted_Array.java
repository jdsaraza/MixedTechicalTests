import java.util.stream.IntStream;

public class Median_Of_Two_Sorted_Array {
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.
Example 2:
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */

    public static void main(String[] args) {
        Median_Of_Two_Sorted_Array test = new Median_Of_Two_Sorted_Array();
        System.out.println(test.findMedianSortedArrays(new int[]{1,3},new int[]{2}));//example 1
        System.out.println(test.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));//example 2

    }

    //First solution, it resolves but does not achieve O(log (m+n))
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        double result = 0;
        int[] aux = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).toArray();//concatenates the two arrays
        java.util.Arrays.sort(aux);//The array is sorted to get the median

        if(aux.length % 2 != 0){
            result = aux[aux.length / 2];//solution to the odd length arrays
        } else {
            result = (aux[aux.length / 2] + aux[aux.length / 2 - 1]) / 2.0;//result to the even length arrays
        }
        return result;
    }

    //achieves O(log (m+n))
    //Searches for the kth element in the two sorted arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            return findKth(nums1, nums2, totalLength / 2 + 1);
        } else {
            double first = findKth(nums1, nums2, totalLength / 2);
            double second = findKth(nums1, nums2, totalLength / 2 + 1);
            return (first + second) / 2.0;
        }
    }

    //auxiliary method to find the kth element
    private int findKth(int[] A, int[] B, int k) {
        int indexA = 0, indexB = 0;

        while (true) {
            if (indexA == A.length) return B[indexB + k - 1];
            if (indexB == B.length) return A[indexA + k - 1];
            if (k == 1) return Math.min(A[indexA], B[indexB]);

            int half = k / 2;
            int newIndexA = Math.min(indexA + half, A.length) - 1;
            int newIndexB = Math.min(indexB + half, B.length) - 1;

            int pivotA = A[newIndexA], pivotB = B[newIndexB];
            if (pivotA <= pivotB) {
                k -= (newIndexA - indexA + 1);
                indexA = newIndexA + 1;
            } else {
                k -= (newIndexB - indexB + 1);
                indexB = newIndexB + 1;
            }
        }
    }

}
