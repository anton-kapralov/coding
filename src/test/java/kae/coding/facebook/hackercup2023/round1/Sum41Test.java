package kae.coding.facebook.hackercup2023.round1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2023.round1.Sum41.*;

@RunWith(value = Parameterized.class)
public class Sum41Test {

  @Parameter public int n;

  @Parameter(1)
  public List<Integer> primeFactors;

  @Parameter(2)
  public List<Integer> addends;

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {2023, List.of(7, 17, 17), List.of(7, 17, 17)},
          {114, List.of(2, 3, 19), List.of(3, 38)},
          {41, List.of(41), List.of(41)},
          {175, List.of(5, 5, 7), List.of(1, 5, 35)},
          {434, List.of(2, 7, 31), List.of(1, 2, 7, 31)},
          {666, List.of(2, 3, 3, 37), null},
          {1872, List.of(2, 2, 2, 2, 3, 3, 13), List.of(2, 4, 9, 26)},
        });
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
    precompute();
  }

  @Test
  public void primeFactorsOf_returnsExpected() {
    assertThat(primeFactorsOf(n)).isEqualTo(primeFactors);
  }

  @Test
  public void solve_returnsExpected() {
    List<Integer> res = solve(n);
    assertThat(res).isEqualTo(addends);
  }
}
