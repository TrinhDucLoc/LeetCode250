import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Set<Integer> hashSet = new HashSet<>();

    for (int num : nums) {
      if (!hashSet.contains(num)) {
        hashSet.add(num);
      }
    }

    int longestValue = 0;

    for (int num : hashSet) {
      if (!hashSet.contains(num - 1)) {
        int length = 1;
        while (hashSet.contains(num + length)) {
          length++;
        }
        longestValue = Math.max(length, longestValue);
      }
    }
    return longestValue;
  }
}
