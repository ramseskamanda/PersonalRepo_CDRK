import java.util.Scanner;

public class TowersHanoi {
  public static void main(String args[]) {
    int n;
    System.out.print("How many disks? ");
    Scanner in = new Scanner(System.in);
    n = in.nextInt();

    hanoi(n, 1, 2);

    System.out.println("All done.");
  }

  // Solve the Towers of Hanoi problem for n disks, a peg on which
  // the disks start, and a peg on which they end.
  public static void hanoi(int n, int startPeg, int endPeg) {
    if (n == 1)
      System.out.println("Move disk 1 from peg " + startPeg + " to peg "
          + endPeg);
    else {
      int sparePeg = 6 - startPeg - endPeg; // the number of the spare peg; 1+2+3 = 6

      hanoi(n - 1, startPeg, sparePeg); // move all but n from startPeg to sparePeg

      System.out.println("Move disk " + n + " from peg " + startPeg
          + " to peg " + endPeg);

      hanoi(n - 1, sparePeg, endPeg); // move all but n from sparePeg to endPeg
    }
  }
}
