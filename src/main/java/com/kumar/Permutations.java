package com.kumar;

import java.util.*;

// nPr = n! / (n - r)!
public class Permutations {
    public static List<List<Integer>> permutations(List<Integer> input, int r) {
        List<List<Integer>> result = new ArrayList<>();

        // Cannot pick r out of input less than r
        if(input.size() < r)  return result;

        // Nothing to pick if r == 0 (return empty)
        if(r == 0)  {
            result.add(new ArrayList<Integer>());
            return result;
        }

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
        result.addAll(permutations(inputClone, r));

        // First IS contained in the answer
        // Pick (r - 1) from remaining (n - 1) elements
        List<List<Integer>> r1ps = permutations(inputClone, r - 1);

        // And add first to every possible place
        for(List<Integer> r1p : r1ps) {
            for(int i = 0; i <= r1p.size(); ++i) {
                List<Integer> rc = new ArrayList<>(r1p);
                rc.add(i, first);

                result.add(rc);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.err.println("Hello Permutations!");

        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);

        List<List<Integer>> result = permutations(input, 3);
        System.err.println(result);
    }
}
