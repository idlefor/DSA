package Codity;

public class MinMaxDivisionCodity {
    /**
     * You are given integers K, M and a non-empty zero-indexed array A consisting of N integers. Every element of the array is not greater than M.
     * You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.
     * The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.
     * The large sum is the maximal sum of any block.
     * For example, you are given integers K = 3, M = 5 and array A such that:
     *   A[0] = 2
     *   A[1] = 1
     *   A[2] = 5
     *   A[3] = 1
     *   A[4] = 2
     *   A[5] = 2
     *   A[6] = 2
     * The array can be divided, for example, into the following blocks:
     * [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
     * [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
     * [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
     * [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
     * The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
     * Write a function:
     * class Solution { public int solution(int K, int M, int[] A); }
     * that, given integers K, M and a non-empty zero-indexed array A consisting of N integers, returns the minimal large sum.
     * Assume that:
     * N and K are integers within the range [1..100,000];
     * M is an integer within the range [0..10,000];
     * each element of array A is an integer within the range [0..M].
     * Complexity:
     * expected worst-case time complexity is O(N*log(N+M));
     * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
     */
    public static void main(String args[]) {
        System.out.println(" result return is " + new MinMaxDivisionCodity().solution(
                3,
                5,
                new int[] {2,1,5,1,2,2,2}
                ));
    }
        public int solution(int K, int M, int[] A) {
            int min = 0;
            int max = 0;
            for(int a : A) {
                max += a;
                min = Math.max(min, a);
            }

            int bestAnswer = max;
            while (min <= max) {
                int mid = (min + max) / 2; // eg. mid = (5 + 15)/2 = 10
                // since k indicate no of block we need check no of block use A and mid value
                if (checkHowManyBlockShouldExist(A, mid) > K) {
                    min = mid + 1; // we increment the mid value by 1 if greater than k mean mid value too low value
                } else {
                   max = mid -1; // if mid value is too high we need bring max down by 1 value
                   if(mid < bestAnswer) {
                       bestAnswer = mid;
                   }
                }
            }
            return bestAnswer;
        }

        private int checkHowManyBlockShouldExist(int[] A, int guess) {
            int blocks = 1; // default 1 block first
            int blockSum = 0;

            for(int a: A) {
                blockSum += a;
                // if sum exceed the guess value which is usually the mid value, we go to next value and increase next
                // block no by 1 count and set set the block sum to current value
                if (blockSum > guess) {
                    blockSum = a;
                    blocks++;
                }
            }
            return blocks;
        }
}