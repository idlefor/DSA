package Codity;

public class MinimiumNoOfGlassesCodity {

    public static void main(String ar[]) {

        System.out.println("result " + new MinimiumNoOfGlassesCodity().solution(5 , 8));
    }

        public int solution(int N, int K) {
            //handle edge case first return 1
            if ( N >= K ) return 1;

            int result = 0;
            for (int i = N; K > 0 && i > 0; i--) {
                if(i <= K) {
                    result++;
                    K -= i;
                }
            }
            return K == 0 ? result : -1; // return - 1 if N , K
        }
}
