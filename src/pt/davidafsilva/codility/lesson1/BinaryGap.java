package pt.davidafsilva.codility.lesson1;

public class BinaryGap {

  public static void main(String[] args) {
    System.out.println(new Solution().solution(1041));
  }

  static class Solution {

    int solution(int N) {
      int counter = 0, biggest = 0;
      while (N > 0) {
        if ((N & 1) > 0) {
          if (counter > 1) {
            biggest = counter > biggest ? counter - 1 : biggest;
          }
          counter = 1;
        } else if (counter > 0) {
          counter++;
        }
        N = N >> 1;
      }
      return biggest;
    }
  }
}


