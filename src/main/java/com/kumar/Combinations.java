package com.kumar;

import java.util.ArrayList;
import java.util.List;

// nCr = n! / ((n - r) ! * r!)
public class Combinations {
    public static List<List<Integer>> combinations(List<Integer> input, int r) {
        List<List<Integer>> result = new ArrayList<>();

        // Cannot pick r out of input less than r and nothing to pick if r == 0
        if(input.size() < r || r == 0)  return result;

        // Pick 1 element from the input
        // Simply each element
        if(r == 1) {
            for(Integer inp : input) {
                List<Integer> inpL = new ArrayList<>();
                inpL.add(inp);

                result.add(inpL);
            }

            return result;
        }

        List<Integer> inputClone = new ArrayList<>(input);
        Integer first = inputClone.remove(0);

        // First IS NOT contained in the answer
        // Pick r from remaining (n - 1) elements
        result.addAll(combinations(inputClone, r));

        // First IS contained in the answer
        // Pick (r - 1) from remaining (n - 1) elements
        List<List<Integer>> r1ps = combinations(inputClone, r - 1);

        // And add first to every combinations from (n - 1)
        for(List<Integer> r1p : r1ps) {
            r1p.add(first);
        }

        result.addAll(r1ps);

        return result;
    }

    public static void main(String[] args) {
        System.err.println("Hello Combinations!");

        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);

        List<List<Integer>> result = combinations(input, 2);
        System.err.println(result);
    }
}
