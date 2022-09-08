package Codity;

public class ArrowSequenceCountCodity {
    public static void main(String args[]) {
        System.out.println(" no of rotation of arrow is " + new ArrowSequenceCountCodity().solution(
                "vv<v><v"
        ));
    }

    public int solution(String S) {
        // base case
        if(S.length() == 0) return 0;

        int strLen = S.length();
        int count_up = 0;
        int count_down = 0;
        int count_right = 0;
        int count_left = 0;
        int no_rotation = 0;

        // iterate the string char by char to increment count for each type of arrow
        for (int i =0; i <strLen; i++) {
            switch(S.charAt(i)) {
                case '^':
                    count_up++;
                    break;
                case 'v':
                    count_down++;
                    break;
                case '>':
                    count_right++;
                    break;
                case '<':
                    count_left++;
                    break;
                default:
                    break;
            }
        }

        // now find which is the arrow is dominate most inside the string
        int[] direction = {count_up, count_down, count_right, count_left};
        int max_count_arrow_pointing_direction = 0;
        int direction_cnt = 0;

        for(int j =0; j < 4; j++) {
            if(direction[j] > max_count_arrow_pointing_direction) {
                direction_cnt = direction[j];
                max_count_arrow_pointing_direction = j;
            }
        }

        for(int k =0; k <4; k++) {
            if(max_count_arrow_pointing_direction != k)
                no_rotation += direction[k];
        }

        return no_rotation;
    }
}
