package kae.study.codingchallenges.algorithms.arrays;

import org.junit.Test;

import java.util.Set;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.algorithms.arrays.BoundedTriplets.findTriplets;

/** */
public class BoundedTripletsTest {

  @Test
  public void findTriplets_returnsExpected_whenArrayIsSorted() {
    Set<Set<Integer>> triplets = findTriplets(new int[] {1, 2, 3, 4, 5}, 10);

    assertThat(triplets)
        .isEqualTo(
            Set.of(
                Set.of(1, 2, 3),
                Set.of(1, 2, 4),
                Set.of(1, 2, 5),
                Set.of(1, 3, 4),
                Set.of(1, 3, 5),
                Set.of(1, 4, 5),
                Set.of(2, 3, 4),
                Set.of(2, 3, 5)));
  }

  @Test
  public void findTriplets_returnsExpected_whenArrayIsUnsorted() {
    Set<Set<Integer>> triplets = findTriplets(new int[] {3, 2, 1, 5, 4}, 10);

    assertThat(triplets)
        .isEqualTo(
            Set.of(
                Set.of(1, 2, 3),
                Set.of(1, 2, 4),
                Set.of(1, 2, 5),
                Set.of(1, 3, 4),
                Set.of(1, 3, 5),
                Set.of(1, 4, 5),
                Set.of(2, 3, 4),
                Set.of(2, 3, 5)));
  }
}
