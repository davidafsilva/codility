package pt.davidafsilva.codility.lesson4;

/**
 * @author david
 */
public class PermCheck {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Solution().solution(new int[]{4, 1, 3}));
  }

  static class Solution {

    int solution(int[] A) {
      final boolean[] result = new boolean[A.length];
      for (final int value : A) {
        int idx = value - 1;
        if (idx < 0 || idx >= A.length || result[idx]) {
          return 0;
        }
        result[idx] = true;
      }

      return 1;
    }
  }
}
