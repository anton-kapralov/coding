package kae.coding.facebook.hackercup2023.round2;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import static com.google.common.truth.Truth.assertThat;

/** */
@RunWith(value = Parameterized.class)
public class ReadyGoTest {

  @Parameter public String bs;

  @Parameter(1)
  public int result;

  @Parameterized.Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
            {"""
W...
B.BB
.BWW
.BW.
""", 3},{"""
W...W
.W.W.
BBWBB
.W.W.
W...W
""", 0},{"""
B..B.
WBBWB
W.WWB
WWBB.
WWB..
""", 9},{"""
.....
WB.BW
BW.WB
BWBWB
.B.B.
""", 4},{"""
.B.B.
BW.WB
.B.B.
""", 2},{"""
B.BWWWWWB.B
BBBWWWWWBBW
WWWWWWWBBWW
BBBWWWWBWWW
BB.BBWBBWWW
WWBWW.WWWWW
WWWWBWBWWWW
WWWBBWBBBWW
WB.BWWWB.BW
WBBWWWWWBBW
WBWWWWWWWBB
""", 61},{"""
..W...W.W..........W.W.............W.BWWWWWB.................
.......................B..............BWWWB.........B........
..................WBBB...............BWWWWB.W...WBBBW........
..................WWWWB..............BWWWWWB....BWWWWB.W....W
.B...........W..BWWWWB.............B.BWWWWB.....BWWWWB.......
BWB...........WWWWWWWW....W..........BWWWWWBB..BWWWWWB.......
.............WWWWWWWWWB..B.........W.BWBW.WB...BWBWWWB.......
...........B..WWWWWWWW................B.BBB.....B.BBB........
....W.........WWWWWWWW.............................BW........
.............BWWWWWWWWB.......W.....B.B.............B.....W..
...W..B.......WWWWWWB....W...B..............................B
.........W.....WBWW.....B..........W.....................W...
...............B...W.....................W............W.....B
.............W...BB.W.........B.....................B........
""", 29},});
  }

  @Test
  public void solve() {
    String[] lns = bs.split("\n");
    char[][] b = new char[lns.length][];
    for (int i = 0; i < lns.length; i++) {
      b[i] = lns[i].toCharArray();
    }
    assertThat(ReadyGo.solve(b)).isEqualTo(result);
  }
}
