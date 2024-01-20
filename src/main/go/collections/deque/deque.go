package deque

type Deque[T any] struct {
	items []T
}

func (d *Deque[T]) Len() int {
	return len(d.items)
}

func (d *Deque[T]) IsEmpty() bool {
	return len(d.items) == 0
}

func (d *Deque[T]) First() T {
	return d.items[0]
}

func (d *Deque[T]) AddFirst(v T) {
	d.items = append([]T{v}, d.items...)
}

func (d *Deque[T]) RemoveFirst() T {
	v := d.items[0]
	var zero T
	d.items[0] = zero
	d.items = d.items[1:]
	return v
}

func (d *Deque[T]) Last() T {
	return d.items[len(d.items)-1]
}

func (d *Deque[T]) AddLast(v T) {
	d.items = append(d.items, v)
}

func (d *Deque[T]) RemoveLast() T {
	last := len(d.items) - 1
	v := d.items[last]
	var zero T
	d.items[last] = zero
	d.items = d.items[:last]
	return v
}
