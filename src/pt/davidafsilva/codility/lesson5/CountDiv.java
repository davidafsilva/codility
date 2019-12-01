package pt.davidafsilva.codility.lesson5;

/**
 * @author david
 */
public class CountDiv {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new CountDiv.Solution().solution(0, 1, 11));
    System.out.println(new CountDiv.Solution().solution(1, 1, 11));
  }

  static class Solution {

    int solution(int A, int B, int K) {
      return B / K - A / K + (A % K == 0 ? 1 : 0);
    }
  }

}
