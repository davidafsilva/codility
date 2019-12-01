package pt.davidafsilva.codility.lesson6;

import static java.util.Arrays.sort;

/**
 * @author david
 */
public class MaxProductOfThree {


  /**
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new MaxProductOfThree.Solution().solution(new int[]{-3, 1, 2, -2, 5, 6}));
  }

  static class Solution {

    int solution(int[] A) {
      if (A.length < 3) {
        return 0;
      }
      sort(A);
      long result = (long) A[A.length - 1] * (long) A[A.length - 2] * (long) A[A.length - 3];
      // handle negative values which multiplied together can produce an higher value
      if (A[0] * A[1] > 0 && A[0] < 0) {
        result = Long.max(result, (long) A[0] * (long) A[1] * (long) A[A.length - 1]);
      }
      return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

  }
}
