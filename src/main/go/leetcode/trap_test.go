package leetcode

import (
	"strconv"
	"testing"
)

func TestTrap(t *testing.T) {
	for i, tc := range []struct {
		heights []int
		want    int
	}{
		{[]int{3, 0, 2}, 2},
		{[]int{4, 2, 0, 1}, 1},
		{[]int{4, 2, 0, 3}, 4},
		{[]int{4, 2, 0, 4}, 6},
		{[]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6},
		{[]int{4, 2, 0, 3, 2, 5}, 9},
	} {
		t.Run(strconv.Itoa(i), func(t *testing.T) {
			got := trap(tc.heights)
			if got != tc.want {
				t.Errorf("trap(%v): got %d; want %d", tc.heights, got, tc.want)
			}
		})
	}
}
