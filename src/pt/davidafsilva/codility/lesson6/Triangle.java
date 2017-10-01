package pt.davidafsilva.codility.lesson6;

/**
 * @author david
 */
public class Triangle {


  /**
   * TODO: improve this initial/first (dumb) solution
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Triangle.Solution().solution(new int[]{10, 2, 5, 1, 8, 20}));
  }

  static class Solution {

    int solution(int[] A) {
      for (int P = 0; P < A.length - 2; P++) {
        for (int Q = P + 1; Q < A.length - 1; Q++) {
          for (int R = Q + 1; R < A.length; R++) {
            if (match(A, P, Q, R)) {
              return 1;
            }
          }
        }
      }

      return 0;
    }

    private boolean match(final int[] A, final int P, final int Q, final int R) {
      final long aq = A[P] + (long) A[Q];
      final long qr = A[Q] + (long) A[R];
      final long rp = A[R] + (long) A[P];
      return P < Q && Q < R && R < A.length &&
          aq > A[R] &&
          qr > A[P] &&
          rp > A[Q];
    }
  }
}
