package leetcode

import "strings"

// https://leetcode.com/problems/text-justification
func fullJustify(words []string, maxWidth int) []string {
	var lines []string
	var currentLine []string
	currentLineMinLen := 0
	for _, w := range words {
		newLen := currentLineMinLen + len(w)
		if len(currentLine) > 0 {
			newLen += 1
		}

		if newLen > maxWidth {
			lines = append(lines, justify(currentLine, maxWidth))
			currentLine = nil
			newLen = len(w)
		}

		currentLineMinLen = newLen
		currentLine = append(currentLine, w)
	}
	if len(currentLine) > 0 {
		var sb strings.Builder
		for _, w := range currentLine {
			if sb.Len() > 0 {
				sb.WriteByte(' ')
			}
			sb.WriteString(w)
		}
		padding := maxWidth - sb.Len()
		for i := 0; i < padding; i++ {
			sb.WriteByte(' ')
		}
		lines = append(lines, sb.String())
	}
	return lines
}

func justify(words []string, width int) string {
	var sb strings.Builder
	sb.WriteString(words[0])

	gaps := len(words) - 1
	if gaps == 0 {
		padding := width - sb.Len()
		for i := 0; i < padding; i++ {
			sb.WriteByte(' ')
		}
		return sb.String()
	}

	wordsWidth := 0
	for _, w := range words {
		wordsWidth += len(w)
	}
	totalSpaces := width - wordsWidth
	totalSpaces -= writeGaps(totalSpaces, gaps, &sb)
	gaps--

	for i := 1; i < len(words); i++ {
		sb.WriteString(words[i])
		if i == len(words)-1 {
			continue
		}
		totalSpaces -= writeGaps(totalSpaces, gaps, &sb)
		gaps--
	}
	return sb.String()
}

func writeGaps(totalSpaces int, gapsLeft int, sb *strings.Builder) int {
	gapSpaces := int(float64(totalSpaces) / float64(gapsLeft))
	if totalSpaces%gapsLeft != 0 {
		gapSpaces++
	}
	for i := 0; i < gapSpaces; i++ {
		sb.WriteByte(' ')
	}
	return gapSpaces
}
