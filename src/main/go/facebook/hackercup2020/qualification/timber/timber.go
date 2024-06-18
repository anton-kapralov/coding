package main

import (
	"bufio"
	"cmp"
	"fmt"
	"io"
	"log"
	"os"
	"slices"
	"strconv"
	"strings"
	"time"
)

type reader struct {
	br *bufio.Reader
}

func newReader(r io.Reader) *reader {
	return &reader{bufio.NewReader(r)}
}

func (r *reader) readLine() string {
	str, err := r.br.ReadString('\n')
	if err != nil {
		log.Fatalf("cannot read string: %s", err)
	}
	return strings.Trim(str, " \r\n")
}

func (r *reader) readInt() int {
	str := r.readLine()
	i, err := strconv.Atoi(str)
	if err != nil {
		log.Fatalf("cannot conver string to int: %s", err)
	}
	return i
}

func (r *reader) readStrings() []string {
	str := r.readLine()
	return strings.Split(str, " ")
}

func (r *reader) readAllInts() []int {
	ss := r.readStrings()
	ii := make([]int, len(ss))
	for i := 0; i < len(ss); i++ {
		v, err := strconv.Atoi(ss[i])
		if err != nil {
			log.Fatalf("cannot conver string to int: %s", err)
		}
		ii[i] = v
	}
	return ii
}

// Problem C: Timber
//
// https://www.facebook.com/codingcompetitions/hacker-cup/2020/qualification-round/problems/C
func main() {
	start := time.Now()
	defer func() { log.Printf("Total: %s", time.Now().Sub(start)) }()
	if len(os.Args) < 2 {
		log.Fatalln("no input file set")
	}
	inputFilename := os.Args[1]
	f, err := os.Open(inputFilename)
	if err != nil {
		log.Fatalln(err)
	}
	r := newReader(f)
	out, err := os.Create(strings.Replace(inputFilename, "_input", "_output", 1))
	defer func() { out.Close() }()
	w := bufio.NewWriter(out)
	defer func() { w.Flush() }()

	t := r.readInt()
	for i := 1; i <= t; i++ {
		parseSolveWrite(i, r, w)
	}
}

type pine struct {
	position int
	height   int
}

func parseSolveWrite(caseNumber int, r *reader, w *bufio.Writer) {
	start := time.Now()
	defer func() { log.Printf("Case #%02d: %s", caseNumber, time.Now().Sub(start)) }()
	n := r.readInt()
	pines := make([]pine, n)
	for i := 0; i < n; i++ {
		vals := r.readAllInts()
		pines[i].position = vals[0]
		pines[i].height = vals[1]
	}
	res := solve(pines)
	_, err := w.WriteString(fmt.Sprintf("Case #%d: %d\n", caseNumber, res))
	if err != nil {
		log.Fatalln(err)
	}
}

func solve(pines []pine) int {
	slices.SortFunc(pines, func(a, b pine) int {
		return cmp.Compare(a.position, b.position)
	})
	l := make(map[int]int)
	maxLen := 0
	for _, p := range pines {
		pl := p.position - p.height
		pr := p.position + p.height

		l[pr] = max(l[pr], l[p.position]+p.height)
		l[p.position] = max(l[p.position], l[pl]+p.height)

		maxLen = max(maxLen, max(l[p.position], l[pr]))
	}
	return maxLen
}
