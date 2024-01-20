package deque

import "testing"

func TestDeque_Len(t *testing.T) {
	dq := &Deque[int]{
		items: []int{1, 2, 3},
	}

	if got := dq.Len(); got != 3 {
		t.Errorf("First(): got %d; want %d", got, 3)
	}
}

func TestDeque_IsEmpty(t *testing.T) {
	for _, tt := range []struct {
		name  string
		items []int
		want  bool
	}{
		{
			name:  "empty",
			items: nil,
			want:  true,
		},
		{
			name:  "non-empty",
			items: []int{1, 2, 3},
			want:  false,
		},
	} {
		t.Run(tt.name, func(t *testing.T) {
			dq := &Deque[int]{
				items: tt.items,
			}

			if got := dq.IsEmpty(); got != tt.want {
				t.Errorf("IsEmpty(): got %t; want %t", got, tt.want)
			}
		})
	}
}

func TestDeque_First(t *testing.T) {
	dq := &Deque[int]{
		items: []int{1, 2, 3},
	}

	if got := dq.First(); got != 1 {
		t.Errorf("First(): got %d; want %d", got, 1)
	}
}

func TestDeque_AddFirst(t *testing.T) {
	dq := &Deque[int]{
		items: []int{1, 2, 3},
	}
	num := 42

	dq.AddFirst(num)

	if got := dq.First(); got != num {
		t.Errorf("First(): got %d; want %d", got, num)
	}
}

func TestDeque_RemoveFirst(t *testing.T) {
	dq := &Deque[int]{
		items: []int{1, 2, 3},
	}

	dq.RemoveFirst()

	if got := dq.First(); got != 2 {
		t.Errorf("First(): got %d; want %d", got, 2)
	}
}

func TestDeque_Last(t *testing.T) {
	dq := &Deque[int]{
		items: []int{1, 2, 3},
	}

	if got := dq.Last(); got != 3 {
		t.Errorf("Last(): got %d; want %d", got, 3)
	}
}

func TestDeque_AddLast(t *testing.T) {
	dq := &Deque[int]{
		items: []int{1, 2, 3},
	}
	num := 42

	dq.AddLast(num)

	if got := dq.Last(); got != num {
		t.Errorf("First(): got %d; want %d", got, num)
	}
}

func TestDeque_RemoveLast(t *testing.T) {
	dq := &Deque[int]{
		items: []int{1, 2, 3},
	}

	dq.RemoveLast()

	if got := dq.Last(); got != 2 {
		t.Errorf("First(): got %d; want %d", got, 2)
	}
}

func BenchmarkDeque_AddFirst(b *testing.B) {
	dq := &Deque[int]{}
	for i := 0; i < b.N; i++ {
		dq.AddFirst(i)
	}
}

func BenchmarkDeque_RemoveFirst(b *testing.B) {
	items := make([]int, b.N)
	for i := 0; i < b.N; i++ {
		items[i] = i
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		dq := &Deque[int]{
			items: items,
		}
		dq.RemoveFirst()
	}
}

func BenchmarkDeque_AddLast(b *testing.B) {
	dq := &Deque[int]{}
	for i := 0; i < b.N; i++ {
		dq.AddLast(i)
	}
}

func BenchmarkDeque_RemoveLast(b *testing.B) {
	items := make([]int, b.N)
	for i := 0; i < b.N; i++ {
		items[i] = i
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		dq := &Deque[int]{
			items: items,
		}
		dq.RemoveLast()
	}
}
