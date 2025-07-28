import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

  public static void main(String[] args) {
    int[] nums = new int[] {2,2,1,1,1,2,2};
    System.out.println(majorityElement(nums));
  }

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!hashMap.containsKey(nums[i])) {
        hashMap.put(nums[i], 1);
      } else {
        hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
      }
    }
    for (Map.Entry<Integer, Integer> hashEntry : hashMap.entrySet()) {
      if (hashEntry.getValue() > nums.length / 2) {
        return hashEntry.getKey();
      }
    }
    return -1;
  }

}

/*
Input: nums = [3,2,3]
Output: 3
Solution:
- HashMap<key, value> with key is element. Value is count element in array
- Loop hashMap if value > nums.length/2 => return key

Optimize:
- Time complexity: O(N)
- Space complexity: O(N)
 */