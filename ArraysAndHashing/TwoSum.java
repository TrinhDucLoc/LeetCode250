import java.util.HashMap;

public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    System.out.println(twoSum(nums, target));
  }
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (hashMap.containsKey(target - nums[i])) {
        return new int[]{hashMap.get(target - nums[i]), i};
      } else {
        hashMap.put(nums[i], i);
      }
    }
    return new int[0];
  }
}
