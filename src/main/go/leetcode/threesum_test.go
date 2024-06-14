package leetcode

import (
	"github.com/google/go-cmp/cmp"
	"testing"
)

func TestThreeSum(t *testing.T) {
	for _, test := range []struct {
		name string
		nums []int
		want [][]int
	}{
		{
			"1",
			[]int{-1, 0, 1, 2, -1, -4},
			[][]int{{-1, -1, 2}, {-1, 0, 1}},
		},
		{
			"2",
			[]int{0, 1, 1},
			nil,
		},
		{
			"3",
			[]int{0, 0, 0},
			[][]int{{0, 0, 0}},
		},
		{
			"4",
			[]int{0, 0, 0, 0},
			[][]int{{0, 0, 0}},
		},
	} {
		t.Run(test.name, func(t *testing.T) {
			got := threeSum(test.nums)
			if diff := cmp.Diff(got, test.want); diff != "" {
				t.Error(diff)
			}
		})
	}
}
