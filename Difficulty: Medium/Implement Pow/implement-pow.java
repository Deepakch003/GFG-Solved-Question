class Solution {
    double power(double b, int e) {
        if (e == 0) {
            return 1.0;
        }

    
        if (e < 0) {
            return 1.0 / power(b, -e);
        }


        if (e % 2 == 0) {
            double half = power(b, e / 2);
            return half * half;
        }

    
        return b * power(b, e - 1);
    }
}