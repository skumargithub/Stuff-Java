package com.kumar;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class QuickSelectTest {
    public int getRandomNumber(Random random, int min, int max) {
//        System.err.println("min: " + min + ", max: " + max);
        return random.nextInt(max - min) + min;
    }

    @Test
    public void quickSelectTest() {
        Random random = new Random();

        final int ARRAY_SIZE = getRandomNumber(random, 100, 1000);
        System.err.println("Array size: " + ARRAY_SIZE);
        int[] input = new int[ARRAY_SIZE];

        for(int i = 0; i < ARRAY_SIZE; ++i) {
            input[i] = getRandomNumber(random, -1000, 1000);
        }
//        System.err.println(Arrays.toString(input));

        int[] B = Arrays.copyOf(input, input.length);
        Arrays.sort(B);
//        System.err.println(Arrays.toString(B));

        for(int i = 0; i < ARRAY_SIZE; ++i) {
            int[] A = Arrays.copyOf(input, input.length);
            int qc = QuickSelect.quickSelect(A, i, 0, A.length - 1);
            assertTrue( qc == B[i]);
        }
    }

    @Test
    public void quickSortTest() {
        Random random = new Random();

        final int ARRAY_SIZE = getRandomNumber(random, 100, 1000);
//        System.err.println("Array size: " + ARRAY_SIZE);
        int[] input = new int[ARRAY_SIZE];

        for(int i = 0; i < ARRAY_SIZE; ++i) {
            input[i] = getRandomNumber(random, -1000, 1000);
        }
//        System.err.println(Arrays.toString(input));

        int[] B = Arrays.copyOf(input, input.length);
        Arrays.sort(B);
        QuickSelect.quickSort(input, 0, input.length - 1);
        assertTrue(Arrays.equals(B, input));
    }
}
