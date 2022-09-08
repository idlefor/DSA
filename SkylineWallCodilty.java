package Codity;

public class SkylineWallCodilty {

    public static void main(String ar[]) {
        int[] arr = {1, 3, 2, 1, 2}; // answer
       // int[] arr = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};  // answer 9
        System.out.println("result " + new SkylineWallCodilty().solution(arr));
    }

    public int solution(int[] A) {
        int outcome = 0;

        for(int i=1; i < A.length; i ++) {
            // find the max between  difference of right wall deduce left wall and sum up to outcome
            outcome += Math.max(0, A[i-1] - A[i]);
        }
        return outcome + A[A.length -1];
    }
}
