package kae.coding.facebook.hackercup2023.round2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

record Index2D(int r, int c) { }

/** */
public class ReadyGo {

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        PrintWriter writer = getWriter(args)) {
      int t = Integer.parseInt(reader.readLine());
      int part = args[0].contains("part_1") ? 1 : 2;
      for (int i = 1; i <= t; i++) {
        long testCaseStart = System.currentTimeMillis();
        solve(i, reader, writer, part);
        System.out.printf("Case #%02d: %d ms%n", i, System.currentTimeMillis() - testCaseStart);
      }
    }
    System.out.printf("%nTotal: %d ms%n", System.currentTimeMillis() - start);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return new PrintWriter(
        new OutputStreamWriter(new FileOutputStream(args[0].replace("input", "output"))));
  }

  private static void solve(int caseNumber, BufferedReader reader, PrintWriter writer, int part)
      throws IOException {
    String[] ss = reader.readLine().split(" ");
    int n = Integer.parseInt(ss[0]);
    int m = Integer.parseInt(ss[1]);
    char[][] b = new char[n][];
    for (int i = 0; i < n; i++) {
      String s = reader.readLine();
      b[i] = s.toCharArray();
    }
    int res = solve(b);
    if (part == 1) {
      writer.printf("Case #%d: %s\n", caseNumber, res > 0 ? "YES" : "NO");
    } else {
      writer.printf("Case #%d: %d\n", caseNumber, res);
    }
  }

  private static final int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  static int solve(char[][] b) {
    int n = b.length;
    int m = b[0].length;

    int max = 0;
    Index2D lastDot = null;
    Map<Index2D, Integer> wm = new HashMap<>();
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (b[i][j] != 'W') {
          continue;
        }
        if (visited[i][j]) {
          continue;
        }
        int count = 0;
        int wcount = 1;
        visited[i][j] = true;
        boolean[][] visitedDots = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
          int[] idx = q.removeFirst();
          for (int[] dir : dirs) {
            int r = idx[0] + dir[0];
            int c = idx[1] + dir[1];

            if (r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || visitedDots[r][c] || b[r][c] == 'B') {
              continue;
            }
            if (b[r][c] == '.') {
              visitedDots[r][c] = true;
              lastDot = new Index2D(r, c);
              count++;
              continue;
            }
            visited[r][c] = true;
            wcount++;
            q.add(new int[] {r, c});
          }
        }

        if (count == 1) {
          wcount = wm.merge(lastDot, wcount, Integer::sum);
          max = Math.max(max, wcount);
        }
      }
    }

    return max;
  }

}
