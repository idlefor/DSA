package Codity;

public class BankTransferCodilty {
    public static void main(String args[]) {
        System.out.println(" no of answer " + new BankTransferCodilty().solution(
                "BAABA",
                new int[] {2,4,1,1,2}
        ));
    }

    public int[] solution(String R, int[] V) {
        int min_bal_A = 0;
        int min_bal_B = 0;
        int balA = 0;
        int balB =0;

        for (int i=0; i < R.length(); i++) {
            if(R.charAt(i) == 'A') {
                balA += V[i];
                balB -= V[i];
                if(balB < min_bal_B)
                    min_bal_B = balB;
            } else if (R.charAt(i) == 'B') {
                balB += V[i];
                balA -= V[i];
                if(balA < min_bal_A)
                    min_bal_A = balA;
            }
        }
    return new int[] {Math.abs(min_bal_A), Math.abs(min_bal_B)};
    }
}
