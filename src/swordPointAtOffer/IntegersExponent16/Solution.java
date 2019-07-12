package swordPointAtOffer.IntegersExponent16;

/**
 * {@author: gcc}
 * {@Date: 2019/6/27 16:03}
 * x^n = (x*x)^(n/2)        n%2=0
 *     = x(x*x)^(n/2)       n%2=1
 *
 */
public class Solution {
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;
    }
}
