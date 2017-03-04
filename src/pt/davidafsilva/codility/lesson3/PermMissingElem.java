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
    System.out.println(new Solution().solution(new int[]{2,3,1,5}));
  }

  static class Solution {

    int solution(int[] A) {
      int sum = 0, expected = 0;
      for (int i=A.length-1; i>=0; i--) {
        sum += A[i];
        expected += (i+2);
      }
      return expected - sum;
    }
  }
}
