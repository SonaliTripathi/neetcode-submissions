class Solution {
    public void sortColors(int[] num) {

        int N = num.length;

        int zero =0;
        int ones = 0;
        int twos = 0;

        for(int i=0; i<N; i++) {
                if (num[i] == 0) zero++;
                if (num[i] == 1) ones++;
                if (num[i] == 2) twos++;
        }

        for(int i=0; i<N; i++) {
            if (zero > 0) {
                num[i] = 0; zero--;
            } else if (ones > 0) {
                num[i] = 1; ones--;
            } else {
                num[i] = 2; twos--;
            }
        }
    }
}