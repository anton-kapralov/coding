package leetcode

import (
	"testing"

	"github.com/google/go-cmp/cmp"
)

func TestFullJustify(t *testing.T) {
	for _, test := range []struct {
		name  string
		words []string
		width int
		want  []string
	}{
		{
			name:  "single line",
			words: []string{"This", "is", "an"},
			width: 16,
			want:  []string{"This is an      "},
		},
		{
			name:  "long word in the middle",
			words: []string{"What", "must", "be", "acknowledgment", "shall", "be"},
			width: 16,
			want:  []string{"What   must   be", "acknowledgment  ", "shall be        "},
		},
		{
			name:  "uneven spaces 3-2",
			words: []string{"example", "of", "text", "justification."},
			width: 16,
			want:  []string{"example  of text", "justification.  "},
		},
		{
			name:  "uneven spaces 5-3",
			words: []string{"Science", "is", "what", "we", "understand"},
			width: 20,
			want:  []string{"Science  is  what we", "understand          "},
		},
		{
			name:  "uneven spaces 7-3",
			words: []string{"This", "is", "an", "an", "example"},
			width: 17,
			want:  []string{"This   is  an  an", "example          "},
		},
	} {
		t.Run(test.name, func(t *testing.T) {
			got := fullJustify(test.words, test.width)
			if diff := cmp.Diff(got, test.want); diff != "" {
				t.Error(diff)
			}
		})
	}
}
