// O(logn)
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long m = n; // assign first and then multiply with -1
        if (m < 0) {
            m = -1 * m;
        }
        while (m > 0) {
            if (m % 2 == 0) {
                x = x * x;
                m /= 2;
            } else {
                res *= x;
                m--;
            }
        }
        return n < 0 ? ((double) 1.0 / (double) res) : res;
    }
}
