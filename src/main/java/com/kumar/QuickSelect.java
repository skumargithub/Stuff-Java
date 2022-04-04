package com.kumar;

import java.util.Arrays;

public class QuickSelect {
    public static void main(String[] args) {
        int[] A = new int[] { 30, 20, 5, 6, 10, 20 };
//        int k = 4;

//        System.err.println(Arrays.toString(A));
//        System.err.println(partition(A, 0, A.length - 1));
//        System.err.println(Arrays.toString(A));
        for(int k = 0; k < A.length; ++k) {
            System.err.println(quickSelect(A, k, 0, A.length - 1));
            System.err.println(Arrays.toString(A));
        }
    }

    public static int quickSelect(int[] A, int k, int start, int end) {
        int part = partition(A, start, end);
        if(part == k) return A[part];
        if(k < part) {
            return quickSelect(A, k, start, part - 1);
        } else {
            return quickSelect(A, k, part + 1, end);
        }
    }

    // Use the last element A[end] as the pivot
    // i -> unexplored
    // lP -> anything less than it is < pivot
    public static int partition(int[] A, int start, int end) {
        if(start > end) return -1;

        int pivot = A[end];

//        System.err.println(Arrays.toString(A));
        int lP = start;
        for(int i = start; i <= end; ++i) {
//            System.err.println("Before-> i: " + i + ", lP: " + lP + ", " + Arrays.toString(A));
            if(A[i] < pivot) {
                int tmp = A[i];
                A[i] = A[lP];
                A[lP++] = tmp;
            }
//            System.err.println("After-> i: " + i + ", lP: " + lP + ", " + Arrays.toString(A));
        }

        A[end] = A[lP];
        A[lP] = pivot;
//        System.err.println("Final: " + Arrays.toString(A));

        return lP;
    }
}
