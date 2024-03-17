package leetcode

import (
	"fmt"
	"testing"
)

func TestStrStr(t *testing.T) {
	for _, tt := range []struct {
		haystack string
		needle   string
		want     int
	}{
		{
			haystack: "a",
			needle:   "a",
			want:     0,
		},
		{
			haystack: "abcdefghi",
			needle:   "abc",
			want:     0,
		},
		{
			haystack: "abcdefghi",
			needle:   "bcd",
			want:     1,
		},
		{
			haystack: "hello",
			needle:   "ll",
			want:     2,
		},
		{
			haystack: "abc",
			needle:   "c",
			want:     2,
		},
	} {
		t.Run(fmt.Sprintf("%s_%s", tt.haystack, tt.needle), func(t *testing.T) {
			got := strStr(tt.haystack, tt.needle)
			if got != tt.want {
				t.Errorf("strStr(%s, %s) = %d; want %d", tt.haystack, tt.needle, got, tt.want)
			}
		})
	}
}
