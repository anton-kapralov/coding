package kae.coding.leetcode;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CrackingSafeTest {

  @Parameter public int n;

  @Parameter(1)
  public int k;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {1, 2},
          {2, 2},
          {3, 2},
          {3, 6},
        });
  }

  @Test
  public void solve() {
    String s = new CrackingSafe().crackSafe(n, k);

    System.out.println(s);
    Set<String> foundPasswords = new HashSet<>();
    for (int i = 0; i < s.length() - n + 1; i++) {
      String password = s.substring(i, i + n);
      assertThat(foundPasswords).doesNotContain(password);
      foundPasswords.add(password);
    }
    List<String> allPasswords = new ArrayList<>();
    permutations(n, k, new StringBuilder(), allPasswords);
    assertThat(foundPasswords).containsExactlyElementsIn(allPasswords);
  }

  private static void permutations(int n, int k, StringBuilder sb, Collection<String> set) {
    if (sb.length() == n) {
      set.add(sb.toString());
      return;
    }

    for (int i = 0; i < k; i++) {
      sb.append(i);
      permutations(n, k, sb, set);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
