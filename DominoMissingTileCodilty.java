package Codity;

import java.util.HashSet;
import java.util.Set;

public class DominoMissingTileCodilty {

    public static void main(String args[]) {
        System.out.println(" missing tile in domingo : " + new DominoMissingTileCodilty().solution(
                new String[] {"0-0", "0-1", "2-3", "2-0"}
        ));
    }

    public String solution(String[] A) {
        Set<String> setTile = new HashSet<>();
        //Store the missing result
        String missing_result = "";

        // form the lookup hashset with reversed and normal facing tiles together store like a lookup dictonary
           for(int i =0; i < A.length; i++) {
            String reversedTile = String.format("%s-%s", A[i].charAt(2) ,A[i].charAt(0));
            // eg. add 1-0
            setTile.add(A[i]);
            // eg . add 0-1
            setTile.add(reversedTile);
        }

        // need iterate 2 time to find the answer for the missing tiles
        outer:
        for(int i=0; i <=6; i++) {
            for(int j=0; j<=6; j++) {
                String currTile = String.format("%s-%s", i, j);

                // nail down which tile is missing since we got a lookup dictonary
                if(!setTile.contains(currTile)) {
                    missing_result = currTile;
                    break outer;
                }
            }
        }
        return missing_result;  // wait go ide run unit to check
    }
}
