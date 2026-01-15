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
        if(N == 0) return 1.0;
        if(N == 1) return x;

        if(N % 2 == 0) {
            return pow(x * x, N/2);
        }

        return x * pow(x, N - 1);
    }
}