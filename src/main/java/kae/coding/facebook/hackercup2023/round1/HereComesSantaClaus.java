package kae.coding.facebook.hackercup2023.round1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * <a href="https://www.facebook.com/codingcompetitions/hacker-cup/2023/round-1/problems/A">Problem
 * A</a>
 */
@SuppressWarnings("DuplicatedCode")
public class HereComesSantaClaus {
  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        PrintWriter writer = getWriter(args)) {
      int t = Integer.parseInt(reader.readLine());

      for (int i = 1; i <= t; i++) {
        long testCaseStart = System.currentTimeMillis();
        solve(i, reader, writer);
        System.out.printf("Case #%02d: %d ms%n", i, System.currentTimeMillis() - testCaseStart);
      }
    }
    System.out.printf("%nTotal: %d ms%n", System.currentTimeMillis() - start);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return new PrintWriter(
        new OutputStreamWriter(new FileOutputStream(args[0].replace("input", "output"))));
  }

  private static void solve(int caseNumber, BufferedReader reader, PrintWriter writer)
      throws IOException {
    int n = Integer.parseInt(reader.readLine());
    int[] nums = new int[n];
    String[] snums = reader.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(snums[i]);
    }
    double res = solve(nums);
    writer.printf("Case #%d: %f\n", caseNumber, res);
  }

  static double solve(int[] nums) {
    Arrays.sort(nums);

    int n = nums.length;
    if (n != 5) {
      double first = (nums[0] + nums[1]) / 2.0;
      double last = (nums[n - 2] + nums[n - 1]) / 2.0;
      return last - first;
    }

    int leftDistance = nums[2] - nums[0];
    int rightDistance = nums[4] - nums[2];

    double first;
    double last;
    if (leftDistance < rightDistance) {
      first = (nums[0] + nums[2]) / 2.0;
      last = (nums[3] + nums[4]) / 2.0;
    } else {
      first = (nums[0] + nums[1]) / 2.0;
      last = (nums[2] + nums[4]) / 2.0;
    }

    return last - first;
  }
}
