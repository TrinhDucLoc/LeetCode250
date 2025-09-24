public class TwoSumII {
  public int[] twoSum(int[] nums, int target) {
    int l = 0, r = nums.length - 1;

    while (l < r) {
      int sumValue = nums[l] + nums[r];
      if (sumValue == target) {
        return new int[] {l + 1, r + 1};
      } else if (sumValue < target) {
        l++;
      } else {
        r--;
      }
    }
    return new int[0];
  }
}
