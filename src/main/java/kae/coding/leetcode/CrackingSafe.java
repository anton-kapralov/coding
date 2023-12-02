package kae.coding.leetcode;

import java.util.HashSet;
import java.util.Set;

/** <a href="https://leetcode.com/problems/cracking-the-safe">753. Cracking the Safe</a> */
public class CrackingSafe {
  public String crackSafe(int n, int k) {
    String start = "0".repeat(n - 1);
    StringBuilder sb = new StringBuilder();
    Set<String> visited = new HashSet<>();
    walk(k, start, sb, visited);
    sb.append(start);
    return sb.toString();
  }

  private void walk(int k, String prefix, StringBuilder sb, Set<String> visited) {
    for (int i = 0; i < k; i++) {
      String pswd = prefix + i;
      if (visited.add(pswd)) {
        walk(k, pswd.substring(1), sb, visited);
        sb.append(i);
      }
    }
  }
}
