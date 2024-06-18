package main

import "testing"

func TestSolve(t *testing.T) {
	for _, test := range []struct {
		name  string
		pines []pine
		want  int
	}{
		{
			name: "7",
			pines: []pine{
				{13, 8},
				{-14, 5},
				{2, 19},
				{33, 10},
				{-31, 9},
				{15, 21},
				{5, 3},
				{-22, 16},
				{-6, 11},
				{25, 12},
				{-40, 24},
				{21, 18},
			},
			want: 56,
		},
	} {
		t.Run(test.name, func(t *testing.T) {
			got := solve(test.pines)
			if got != test.want {
				t.Errorf("solve(): %d; want %d", got, test.want)
			}
		})
	}
}
