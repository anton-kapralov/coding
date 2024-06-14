package leetcode

import "slices"

// https://leetcode.com/problems/3sum
func threeSum(nums []int) [][]int {
	slices.Sort(nums)
	var triplets [][]int
	visited := make(map[int]struct{})
	for i := 0; i < len(nums)-2; i++ {
		if _, exists := visited[-nums[i]]; exists {
			continue
		}
		triplets = append(triplets, twoSum(nums, -nums[i], i+1)...)
		visited[-nums[i]] = struct{}{}
	}
	return triplets
}

func twoSum(nums []int, target int, start int) [][]int {
	var res [][]int
	visited := make(map[int]struct{})
	l, r := start, len(nums)-1
	for l < r {
		s := nums[l] + nums[r]
		if s > target {
			r--
			continue
		}
		if s < target {
			l++
			continue
		}
		if _, exists := visited[nums[l]]; !exists {
			res = append(res, []int{-target, nums[l], nums[r]})
			visited[nums[l]] = struct{}{}
		}
		l++
	}
	return res
}
