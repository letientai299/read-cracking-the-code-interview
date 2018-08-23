package bit_manipulation;

import java.util.BitSet;

public class BitManipulation {
  /**
   * 5.1 Convert all bits between j and j in given N so that they are equals to M.
   *
   * N = 100000000000000 M = 101 i = 3 j = 5
   *
   * After convert: N = 100000000101000
   *
   * Assume that input is valid.
   */
  static long turnBits(long n, long m, int i, int j) {
    final BitSet big = BitSet.valueOf(new long[] {n});
    final BitSet small = BitSet.valueOf(new long[] {m});
    for (int k = i; k <= j; k++) {
      big.set(k, small.get(k - i));
    }

    return big.toLongArray()[0];
  }

  static long turnBitsBitShifting(long n, long m, int i, int j) {
    long backup = n & ((1 << i) - 1);
    long x = (n >> j) << (j - i);
    long y = x | m;
    long z = (y << i) | backup;
    return z;
  }

  /**
   * Convert a binary String into float. Assuming input is valid.
   */
  static float fromBinaryString(String s) {
    if (!s.contains(".")) {
      return Long.valueOf(s, 2);
    }

    final String[] ss = s.split("\\.");
    final String intParts = ss[0];
    float v = 0;
    v += Long.valueOf(intParts, 2);

    final String fractionalPart = ss[1];
    for (int i = 0; i < fractionalPart.length(); i++) {
      if (fractionalPart.charAt(i) == '1') {
        v += 1.0 / (2 << i);
      }
    }

    return v;
  }

  /*
   * 5.4 Explain what this does:
   *
   * ((n & (n-1)) == 0
   *
   * It check if n and (n-1) doesn't have any common bit. Only n=2^x can have such property.
   */

}
