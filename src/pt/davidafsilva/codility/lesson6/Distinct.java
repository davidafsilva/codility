package pt.davidafsilva.codility.lesson6;

/**
 * @author david
 */
public class Distinct {


  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new Distinct.Solution().solution(new int[]{2, 1, 1, 2, 3, 1}));
  }

  static class Solution {

    int solution(int[] A) {
      final java.util.Set<Integer> unique = new java.util.LinkedHashSet<>();
      for (int v : A) {
        unique.add(v);
      }
      return unique.size();
    }
  }

}
