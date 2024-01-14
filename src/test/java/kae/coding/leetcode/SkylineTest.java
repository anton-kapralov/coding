package kae.coding.leetcode;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SkylineTest {

  @Parameter public int[][] buildings;

  @Parameter(1)
  public int[][] result;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[][] {{0, 2, 2}}, new int[][] {{0, 2}, {2, 0}}},
          {new int[][] {{0, 2, 2}, {0, 2, 3}}, new int[][] {{0, 3}, {2, 0}}},
          {new int[][] {{0, 2, 2}, {0, 3, 3}}, new int[][] {{0, 3}, {3, 0}}},
          {new int[][] {{0, 2, 2}, {0, 1, 3}}, new int[][] {{0, 3}, {1, 2}, {2, 0}}},
          {new int[][] {{0, 2, 2}, {1, 2, 3}}, new int[][] {{0, 2}, {1, 3}, {2, 0}}},
          {new int[][] {{0, 2, 2}, {1, 4, 3}}, new int[][] {{0, 2}, {1, 3}, {4, 0}}},
          {new int[][] {{0, 4, 2}, {1, 3, 3}}, new int[][] {{0, 2}, {1, 3}, {3, 2}, {4, 0}}},
          {new int[][] {{0, 2, 3}, {1, 3, 2}}, new int[][] {{0, 3}, {2, 2}, {3, 0}}},
          {new int[][] {{0, 2, 2}, {2, 4, 2}}, new int[][] {{0, 2}, {4, 0}}},
          {
            new int[][] {{0, 2, 2}, {1, 4, 4}, {3, 6, 3}},
            new int[][] {{0, 2}, {1, 4}, {4, 3}, {6, 0}}
          },
          {
            new int[][] {{0, 2, 2}, {1, 4, 4}, {3, 6, 3}, {7, 8, 1}},
            new int[][] {{0, 2}, {1, 4}, {4, 3}, {6, 0}, {7, 1}, {8, 0}}
          },
          {
            new int[][] {{0, 4, 2}, {1, 3, 3}, {2, 5, 2}},
            new int[][] {{0, 2}, {1, 3}, {3, 2}, {5, 0}}
          },
          {
            new int[][] {{0, 2, 4}, {1, 3, 2}, {2, 4, 3}},
            new int[][] {{0, 4}, {2, 3}, {4, 0}}
          },
        });
  }

  @Test
  public void getSkyline() {
    List<List<Integer>> want = new ArrayList<>(result.length);
    for (int[] point : result) {
      want.add(List.of(point[0], point[1]));
    }

    List<List<Integer>> got = new Skyline().getSkyline(buildings);

    assertThat(got).isEqualTo(want);
  }
}
