import java.util.Scanner;
//Successful attempt at only displaying steps needed to solve puzzle.
//Was also modeled after other algorithms found on Google
public class TowersHanoi {
  public static void main(String args[]) {
    System.out.print("How many disks? ");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    solution(n, 1, 2);

    System.out.println("All done.");
  }

  public static void solution(int n, int start_rod, int end_rod) {
    if (n == 1) System.out.println("Move disk 1 from rod " + start_rod + " to rod " + end_rod);
    else {
      int spare_rod = 6 - start_rod - end_rod;

      solution(n - 1, start_rod, spare_rod);

      System.out.println("Move disk " + n + " from rod " + start_rod + " to rod " + end_rod);

      solution(n - 1, spare_rod, end_rod);
    }
  }
}
