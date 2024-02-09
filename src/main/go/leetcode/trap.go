package leetcode

type bar struct {
	i int
	h int
}

// https://leetcode.com/problems/trapping-rain-water
func trap(height []int) int {
	w := 0
	s := make([]bar, 0, len(height))
	for i, h := range height {
		if h == 0 {
			continue
		}

		p := 0
		for len(s) > 0 {
			n := len(s)
			d := min(s[n-1].h, h) - p
			p = s[n-1].h
			w += (i - s[n-1].i - 1) * d

			if s[n-1].h > h {
				break
			}
			s = s[:n-1]
		}
		s = append(s, bar{i, h})
	}

	return w
}
