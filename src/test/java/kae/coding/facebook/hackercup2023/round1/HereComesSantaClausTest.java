package kae.coding.facebook.hackercup2023.round1;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2023.round1.HereComesSantaClaus.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class HereComesSantaClausTest {

  @Parameter public int[] nums;

  @Parameter(1)
  public double result;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {1, 17, 3, 13, 7, 23, 12}, 18},
          {new int[] {5, 4, 3, 2, 1}, 2.5},
          {new int[] {10, 100, 1000, 10000}, 5445},
        });
  }

  @Test
  public void solve_returnsExpected() {
    assertThat(solve(nums)).isEqualTo(result);
  }
}
