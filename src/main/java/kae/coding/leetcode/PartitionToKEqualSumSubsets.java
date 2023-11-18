package kae.coding.leetcode;

/**
 * <a href="https://leetcode.com/problems/partition-to-k-equal-sum-subsets">698. Partition to K
 * Equal Sum Subsets</a>
 */
public class PartitionToKEqualSumSubsets {

  public static boolean solve(int[] nums, int k) {
    int n = nums.length;
    if (n < k) {
      return false;
    }
    int totalSum = 0;
    for (int v : nums) {
      totalSum += v;
    }
    if (totalSum % k != 0) {
      return false;
    }
    int target = totalSum / k;
    return search(nums, k, target, 0, 0, new boolean[n]);
  }

  private static boolean search(int[] nums, int k, int target, int l, int sum, boolean[] chosen) {
    int n = nums.length;
    if (k == 1) {
      for (int i = 0; i < n; i++) {
        if (chosen[i]) {
          continue;
        }
        sum += nums[i];
      }
      return sum == target;
    }

    if (sum == target) {
      return search(nums, k - 1, target, 0, 0, chosen);
    }

    for (int i = l; i < n; i++) {
      if (chosen[i]) {
        continue;
      }
      if (sum + nums[i] > target) {
        continue;
      }
      chosen[i] = true;
      boolean found = search(nums, k, target, i + 1, sum + nums[i], chosen);
      if (found) {
        return true;
      }
      chosen[i] = false;
    }

    return false;
  }
}
