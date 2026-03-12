class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if(N < 0) {
            N = -N;
            x = 1/x;
        }

        return pow(x, N);
    }

    private double pow(double x, long N) {
        double result = 1;

        while(N > 0) {

            if((N & 1) == 1) {
                result *= x;
            }

            x *= x;
            N /= 2;
        }

        return result;
    }
}