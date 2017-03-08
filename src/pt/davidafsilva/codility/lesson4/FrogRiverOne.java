package pt.davidafsilva.codility.lesson4;

/**
 * @author david
 */
public class FrogRiverOne {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Solution().solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
  }

  static class Solution {

    int solution(int X, int[] A) {
      int added = 0;
      final boolean[] jumps = new boolean[X];
      for (int i = 0; i < A.length; i++) {
        int idx = A[i] - 1;
        if (!jumps[idx]) {
          added++;
          jumps[idx] = true;
        }
        if (added == X) return i;
      }
      return -1;
    }
  }
}
