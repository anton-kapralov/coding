package leetcode

func strStr(haystack, needle string) int {
	const (
		a = 3
		b = 127
	)

	hh := make([]int64, len(haystack))
	hh[0] = int64(haystack[0])
	for i := 1; i < len(haystack); i++ {
		hh[i] = (hh[i-1]*a + int64(haystack[i])) % b
	}

	p := make([]int64, len(haystack))
	p[0] = 1
	for i := 1; i < len(haystack); i++ {
		p[i] = (p[i-1] * a) % b
	}

	h := int64(needle[0])
	for i := 1; i < len(needle); i++ {
		h = (h*a + int64(needle[i])) % b
	}

	for i := 0; i <= len(haystack)-len(needle); i++ {
		l, r := i, i+len(needle)-1
		var candidateHash int64
		if l == 0 {
			candidateHash = hh[r]
		} else {
			candidateHash = (hh[r] - hh[l-1]*p[r-l+1]%b) % b
		}
		if candidateHash < 0 {
			candidateHash += b
		}
		if h == candidateHash && haystack[l:r+1] == needle {
			return i
		}
	}
	return -1
}
