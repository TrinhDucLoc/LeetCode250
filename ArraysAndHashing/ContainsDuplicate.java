import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    HashSet<Integer> map = new HashSet<>();
    for (int item : nums) {
      if (map.contains(item)) {
        return true;
      } else {
        map.add(item);
      }
    }
    return false;
  }

}
