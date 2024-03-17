package leetcode

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
func strStr(s, needle string) int {
	const (
		a = 3
		b = 127
	)

	m := len(s)
	n := len(needle)

	if n == 0 || m == 0 || n > m {
		return -1
	}

	p := make([]int, m)
	p[0] = 1
	for i := 1; i < m; i++ {
		p[i] = (p[i-1] * a) % b
	}

	h := make([]int, m)
	h[0] = int(s[0])
	for i := 1; i < m; i++ {
		h[i] = (h[i-1]*a + int(s[i])) % b
	}

	hash := func(i, j int) int {
		if i == 0 {
			return h[j]
		}
		return (h[j] - h[i-1]*p[j-i+1]%b + b) % b
	}

	nh := int(needle[0])
	for i := 1; i < n; i++ {
		nh = (nh*a + int(needle[i])) % b
	}

	for i := 0; i <= m-n; i++ {
		if nh != hash(i, i+n-1) {
			continue
		}
		if s[i:i+n] == needle {
			return i
		}
	}

	return -1
}
