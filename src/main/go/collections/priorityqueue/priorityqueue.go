package priorityqueue

import (
	"container/heap"
	"fmt"
)

type PriorityQueue[T any] interface {
	heap.Interface
	Peek() T
}

type priorityQueue[T any] struct {
	items []T
	less  func(a, b T) bool
}

func (pq *priorityQueue[T]) Peek() T {
	return pq.items[0]
}

func (pq *priorityQueue[T]) Push(x any) {
	item := x.(T)
	pq.items = append(pq.items, item)
}

func (pq *priorityQueue[T]) Pop() any {
	n := len(pq.items)
	item := pq.items[n-1]
	var zero T
	pq.items[n-1] = zero
	pq.items = pq.items[:n-1]
	return item
}

func (pq *priorityQueue[T]) Len() int {
	return len(pq.items)
}

func (pq *priorityQueue[T]) Less(i, j int) bool {
	return pq.less(pq.items[i], pq.items[j])
}

func (pq *priorityQueue[T]) Swap(i, j int) {
	pq.items[i], pq.items[j] = pq.items[j], pq.items[i]
}

func (pq *priorityQueue[T]) String() string {
	return fmt.Sprint(pq.items)
}

func New[T any](less func(a, b T) bool) PriorityQueue[T] {
	return &priorityQueue[T]{
		less: less,
	}
}
