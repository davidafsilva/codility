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
      final int rotations = K == 0 ? 0 : K % A.length;
      if (rotations == 0) return A;
      for (int i = 0; i < rotations; i++) swap(A, i, (i + rotations) % A.length);
      return A;
    }

    private void swap(final int[] A, final int i1, final int i2) {
      final int tmp = A[i1];
      A[i1] = A[i2];
      A[i2] = tmp;
    }
  }
}
