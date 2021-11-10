package com.kumar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class CombinationsTest {
    public static int factorial(int n) {
        int result = 1;
        for(int i = 1; i <= n; ++i) {
            result *= i;
        }

        return result;
    }

    public int getRandomNumber(int min, int max) {
//        System.err.println("min: " + min + ", max: " + max);
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Test
    public void c0()
    {
        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);

        List<List<Integer>> result = Permutations.permutations(input, 0);
        assertTrue( result.size() == 0);
    }

    @Test
    public void c1()
    {
        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);

        List<List<Integer>> result = Permutations.permutations(input, 1);
        assertTrue( result.size() == factorial(input.size()) / factorial(input.size() - 1));

        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> e0 = new ArrayList<>();
        e0.add(0);
        expectedResult.add(e0);

        List<Integer> e1 = new ArrayList<>();
        e1.add(1);
        expectedResult.add(e1);

        List<Integer> e2 = new ArrayList<>();
        e2.add(2);
        expectedResult.add(e2);

        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void p2()
    {
        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);

        int R = 2;
        List<List<Integer>> result = Permutations.permutations(input, R);
//        System.err.println(result);
        assertTrue( result.size() == factorial(input.size()) / factorial(input.size() - R));

        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> e0 = new ArrayList<>();
        e0.add(1);
        e0.add(2);
        expectedResult.add(e0);

        List<Integer> e1 = new ArrayList<>();
        e1.add(2);
        e1.add(1);
        expectedResult.add(e1);

        List<Integer> e2 = new ArrayList<>();
        e2.add(0);
        e2.add(1);
        expectedResult.add(e2);

        List<Integer> e3 = new ArrayList<>();
        e3.add(1);
        e3.add(0);
        expectedResult.add(e3);

        List<Integer> e4 = new ArrayList<>();
        e4.add(0);
        e4.add(2);
        expectedResult.add(e4);

        List<Integer> e5 = new ArrayList<>();
        e5.add(2);
        e5.add(0);
        expectedResult.add(e5);

        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void countTest()
    {
        for(int i = 0; i < 100; ++i) {
            int N = getRandomNumber(2, 10);
            int R = getRandomNumber(1, N);

            List<Integer> input = new ArrayList<>();
            for(int n = 0; n < N; ++n) {
                input.add(n);
            }

            List<List<Integer>> result = Permutations.permutations(input, R);
            System.err.println("N: " + N + ", R: " + R + ", count: " + result.size());
//        System.err.println(result);
            assertTrue(result.size() == factorial(N) / factorial(N - R));
        }
    }
}
