package pt.davidafsilva.codility.lesson3;

/**
 * @author david
 */
public class PermMissingElem {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Solution().solution(new int[]{2, 3, 1, 5}));
  }

  static class Solution {

    int solution(int[] A) {
      int total = 0, expected = A.length;
      for (int i = 0; i < A.length; i++) {
        total += A[i];
        expected += A[i];
      }
      return expected - total;
    }
  }
}
