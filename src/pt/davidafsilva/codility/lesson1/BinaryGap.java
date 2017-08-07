package pt.davidafsilva.codility.lesson1;

public class BinaryGap {

  public static void main(String[] args) {
    System.out.println(new Solution().solution(1041));
  }

  static class Solution {

    int solution(int N) {
      int counter = 0, biggest = 0;
      while (N > 0) {
        counter = (N & 1) > 0 ? 0 : counter + 1;
        biggest = counter > biggest ? counter : biggest;
        N = N >> 1;
      }
      return biggest;
    }
  }
}


