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
      final int[] lr = new int[A.length];
      lr[0] = A[0];
      final int[] rl = new int[A.length];
      rl[A.length - 1] = A[A.length - 1];

      for (int i = 1; i < A.length; i++) {
        lr[i] = lr[i - 1] + A[i];
        rl[A.length - i - 1] = rl[A.length - i] + A[A.length - i - 1];
      }

      return IntStream.range(0, A.length - 1)
          .map(i -> Math.abs(lr[i] - rl[i + 1]))
          .min()
          .orElse(0);
    }
  }
}
