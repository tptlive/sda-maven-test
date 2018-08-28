package ee.sda.maven.hackerrank;

public class DiagonalDifference {

  public DiagonalDifference() {
    System.out.println("new DiagonalDifference has been created");
  }

  public int diagonalDifference(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (i == j) {
          sum += arr[i][j] - arr[i][(arr[i].length - 1) - j];
        }
      }
    }
    return Math.abs(sum);
  }

}
