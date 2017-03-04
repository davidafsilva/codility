package pt.davidafsilva.codility.lesson2;

import java.util.Arrays;

/**
 * @author david
 */
public class CyclicRotation {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(Arrays.toString(new Solution().solution(new int[]{3, 8, 9, 7, 6}, 3)));
  }

  static class Solution {

    public int[] solution(int[] A, int K) {
      if (K == 0 || A.length == 0 || K % A.length == 0) {
        return A;
      }
      final int[] B = new int[A.length];
      for (int i = 0; i < A.length; i++) {
        B[(i + K) % A.length] = A[i];
      }
      return B;
    }
  }
}
