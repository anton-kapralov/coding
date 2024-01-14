package kae.coding.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Skyline {

  record Segment(int x1, int x2, int y) implements Comparable<Segment> {
    @Override
    public int compareTo(Segment o) {
      return x1 != o.x1 ? Integer.compare(x1, o.x1) : -Integer.compare(y, o.y);
    }
  }

  public List<List<Integer>> getSkyline(int[][] buildings) {
    if (buildings.length == 0) {
      return Collections.emptyList();
    }

    PriorityQueue<Segment> pq = new PriorityQueue<>(buildings.length);
    for (int[] bldg : buildings) {
      pq.add(new Segment(bldg[0], bldg[1], bldg[2]));
    }

    List<List<Integer>> res = new ArrayList<>();

    Segment current = null;
    while (!pq.isEmpty()) {
      Segment next = pq.remove();
      if (current == null) {
        res.add(List.of(next.x1, next.y));
        current = next;
        continue;
      }

      if (current.x2 < next.x1) {
        // no intersections
        res.add(List.of(current.x2, 0));
        res.add(List.of(next.x1, next.y));
        current = next;
        continue;
      }

      // next intersects current, i. e. current.x2 >= next.x1

      if (current.y == next.y) {
        // same height
        if (current.x2 < next.x2) {
          // extend current to the end of next
          current = new Segment(current.x1, next.x2, current.y);
        }
        continue;
      }

      if (current.y > next.y) {
        // current is higher than next

        if (current.x2 >= next.x2) {
          // next is completely inside
          continue;
        }

        if (current.x2 > next.x1) {
          // cut the tail of the next and add it to the queue
          pq.add(new Segment(current.x2, next.x2, next.y));
          continue;
        }

        res.add(List.of(current.x2, next.y));
        current = new Segment(current.x2, next.x2, next.y);
        continue;
      }

      // current is lower than next
      // it means current.x1 < next.x1 per pq sorting order
      res.add(List.of(next.x1, next.y));
      if (current.x2 > next.x2) {
        // cut the tail of the current and add it to the queue
        pq.add(new Segment(next.x2, current.x2, current.y));
      }
      current = next;
    }

    res.add(List.of(current.x2, 0));

    return res;
  }
}
