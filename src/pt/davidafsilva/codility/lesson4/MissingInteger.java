package pt.davidafsilva.codility.lesson4;

import java.util.BitSet;

/**
 * @author david
 */
public class MissingInteger {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Solution().solution(new int[]{1,3,6,4,1,2}));
  }

  static class Solution {

    int solution(int[] A) {
      final BitSet bits = new BitSet(A.length);
      for (int num : A) {
        if (num <= 0 || num > bits.size()) {
          continue;
        }
        bits.set(num - 1);
      }

      final int missing = bits.nextClearBit(0);
      return missing == -1 ? A.length + 1 : missing + 1;
    }
  }
}
