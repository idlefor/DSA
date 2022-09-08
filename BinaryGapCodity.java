package Codity;

public class BinaryGapCodity {

    public static void main(String ar[]) {
        Integer val = 328;
        System.out.println("evaluating value "+ val +" to have max binary gap at " + new BinaryGapCodity().findBinaryGap(val));
    }

    public Integer findBinaryGap(Integer N) {
        // eg. n = 328  binary is 101001000
        String binaryNumber = Integer.toBinaryString(N);
        //  binaryNumber.substring(0, binaryNumber.lastIndexOf("1")) give 10100
        //  binaryStr.replaceAll("0+$", "")  give u 101001
        //  eg. String [] gap will ["", "0", "00"]
        // String[] gaps = binaryNumber.replaceAll("0+$", "").split("1");
        String[] gaps = binaryNumber.substring(0, binaryNumber.lastIndexOf("1")).split("1");

        int maxLength = 0;
        for (String gap: gaps) {
            if (gap.length() > 0 && gap.length() > maxLength) {
                maxLength = gap.length();
            }
        }
        return maxLength;
    }

}
