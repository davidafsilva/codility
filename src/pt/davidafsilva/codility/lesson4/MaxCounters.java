package pt.davidafsilva.codility.lesson4;

import java.util.Arrays;

/**
 * @author david
 */
public class MaxCounters {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(Arrays.toString(new Solution().solution(5, new int[]{1,1,6,1,3,3,3})));
  }

  static class Solution {

    int[] solution(int N, int[] A) {
      final int[] counters = new int[N];
      int max = 0, lastMax = 0;

      // O(n)
      for (int value : A) {
        int idx = value - 1;
        if (value == N + 1) {
          lastMax = max;
          continue;
        }

        counters[idx] = Math.max(counters[idx], lastMax) + 1;
        max = Math.max(counters[idx], max);
      }

      // O(m)
      for (int i = 0; i < counters.length; i++) {
        counters[i] = Math.max(counters[i], lastMax);
      }

      return counters;
    }
  }
}
