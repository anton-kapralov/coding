package kae.coding.utils;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class Index2DTest {

  @Parameter
  public int r;
  @Parameter(1)
  public int c;
  @Parameter(2)
  public int width;
  @Parameter(3)
  public int result;

  @Parameters(name = "{0},{1},{2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][] {
                    {1, 2, 4, 6},
                    {1, 2, 5, 7},
            });
  }

  @Test
  public void flatten() {
    assertThat(Index2D.flatten(r, c, width)).isEqualTo(result);
  }
}
