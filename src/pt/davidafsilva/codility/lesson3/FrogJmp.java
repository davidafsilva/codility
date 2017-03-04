package pt.davidafsilva.codility.lesson3;

/**
 * @author david
 */
public class FrogJmp {

  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Solution().solution(10, 85, 30));
  }

  static class Solution {

    int solution(int X, int Y, int D) {
      return (int) Math.ceil((Y - X) / (D + 0.0));
    }
  }
}
