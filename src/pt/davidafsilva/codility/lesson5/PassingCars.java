package pt.davidafsilva.codility.lesson5;

/**
 * @author david
 */
public class PassingCars {


  /**
   * Let's go!
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    System.out.println(new PassingCars.Solution().solution(new int[]{0, 1, 0, 1, 1}));
  }

  static class Solution {

    int solution(int[] A) {
      int add = 0, counter = 0;
      for (final int value : A) {
        if (value == 0) {
          add++;
        } else if (add > 0) {
          counter += add;
        }

        if (counter > 1_000_000_000) {
          return -1;
        }
      }

      return counter;
    }
  }

}
