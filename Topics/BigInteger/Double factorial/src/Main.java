import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        // type your java code here
        if (n == 0 || n == 1) {
//            System.out.println(BigInteger.ONE);
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.ONE;

        for (int i = n; i > 0; i -= 2) {
            result = result.multiply(BigInteger.valueOf(i));
        }
//        System.out.println(result);
        return result;
    }
}