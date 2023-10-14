package kae.coding.facebook.hackercup2023.round1;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.facebook.com/codingcompetitions/hacker-cup/2023/round-1/problems/B1">Problem
 * B1</a>
 * <a href="https://www.facebook.com/codingcompetitions/hacker-cup/2023/round-1/problems/B2">Problem
 * B2</a>
 */
public class Sum41 {
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

  static Map<Integer, List<Integer>> dp = new HashMap<>();

  private static void solve(int caseNumber, BufferedReader reader, PrintWriter writer)
      throws IOException {
    int n = Integer.parseInt(reader.readLine());
    precompute();
    List<Integer> res = solve(n);
    if (res == null) {
      writer.printf("Case #%d: -1\n", caseNumber);
      return;
    }

    writer.printf("Case #%d: %d", caseNumber, res.size());
    for (Integer i : res) {
      writer.printf(" %d", i);
    }
    writer.println();
  }

  static List<Integer> primeFactorsOf(int n) {
    List<Integer> res = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      while (n % i == 0) {
        res.add(i);
        n /= i;
      }
    }
    return res;
  }

  static List<Integer> solve(int n) {
    return dp.get(n);
  }

  static void precompute() {
    sum41(new ArrayDeque<>(), 0, 1, 1);
  }

  static void sum41(Deque<Integer> dq, int s, int p, int c) {
    if (s == 41) {
      List<Integer> factors = dp.get(p);
      if (factors == null || dq.size() < factors.size()) {
        dp.put(p, new ArrayList<>(dq));
      }
    }

    for (int i = c; s + i <= 41; i++) {
      dq.addLast(i);
      sum41(dq, s + i, p * i, i);
      dq.removeLast();
    }
  }
}
