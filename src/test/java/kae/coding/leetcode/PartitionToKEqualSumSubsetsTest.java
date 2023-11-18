package kae.coding.leetcode;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class PartitionToKEqualSumSubsetsTest {

  @Parameter public int[] nums;

  @Parameter(1)
  public int k;

  @Parameter(2)
  public boolean result;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {1}, 1, true},
          {new int[] {1}, 2, false},
          {new int[] {1, 2}, 2, false},
          {new int[] {4, 3, 2, 3, 5, 2, 1}, 4, true},
          {new int[] {4, 3, 2, 3, 5, 2, 1}, 4, true},
          {new int[] {1, 2, 3, 4}, 3, false},
          {new int[] {2, 2, 2, 2, 3, 4, 5}, 4, false},
          {
            new int[] {129, 17, 74, 57, 1421, 99, 92, 285, 1276, 218, 1588, 215, 369, 117, 153, 22},
            3,
            true
          },
        });
  }

  @Test
  public void solve() {
    assertThat(PartitionToKEqualSumSubsets.solve(nums, k)).isEqualTo(result);
  }
}
