package pt.davidafsilva.codility.lesson2;

/**
 * @author david
 */
public class OddOccurrencesInArray {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Solution().solution(new int[]{9,3,9,3,9,7,9}));
  }

  static class Solution {

    public int solution(int[] A) {
      if (A.length==0) return 0;
      for (int i=1; i<A.length; i++) {
        A[0] = A[0] ^ A[i];
      }
      return A[0];
    }
  }
}
