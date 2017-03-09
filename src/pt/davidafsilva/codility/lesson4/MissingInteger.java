package pt.davidafsilva.codility.lesson4;

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
    System.out.println(new Solution().solution(new int[]{-1, Integer.MAX_VALUE}));
  }

  static class Solution {

    // TODO: improve this solution...
    int solution(int[] A) {
      java.util.Arrays.sort(A);
      int last = Integer.MIN_VALUE;
      for (int i = 0; i < A.length; i++) {
        if ((i == 0 || (i>0 && last < 0)) && A[i] > 1) {
          return 1;
        }

        if (i > 0 && A[i] > 0 && last >= 0 && A[i] - last > 1) {
          return A[i - 1] + 1;
        }

        last = A[i];
      }
      return last <= 0 ? 1 : last + 1;
    }
  }
}
