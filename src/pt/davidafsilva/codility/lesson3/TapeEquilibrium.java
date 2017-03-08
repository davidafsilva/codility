package pt.davidafsilva.codility.lesson3;

import java.util.stream.IntStream;

/**
 * @author david
 */
public class TapeEquilibrium {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Solution().solution(new int[]{3, 1, 2, 4, 3}));
  }

  static class Solution {

    int solution(int[] A) {
      final int[] left = new int[A.length];
      final int[] right = new int[A.length];
      for (int p = 0; p < A.length - 1; p++) {
        left[p] = p == 0 ? A[p] : left[p - 1] + A[p];
        right[A.length - 2 - p] = A[A.length - 1 - p] + (p == 0 ? 0 : right[A.length - p - 1]);
      }

      return IntStream.range(0, A.length - 1)
          .map(idx -> Math.abs(left[idx] - right[idx]))
          .min().orElse(0);
    }
  }
}
