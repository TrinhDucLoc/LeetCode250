import java.util.TreeSet;

public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
//    TreeSet<Integer> hashSet = new TreeSet<>();
//    for (int num : nums) {
//      if (!hashSet.contains(num)) {
//        hashSet.add(num);
//      }
//    }
//
//    int i = 0;
//    for (int num : hashSet) {
//      nums[i++] = num;
//    }
//    return hashSet.size();

    int l = 0, r = 0, n = nums.length;

    while (r < n) {
      nums[l] = nums[r];
      while (r < n && nums[l] == nums[r]) {
        r++;
      }
      l++;
    }
    return l;
  }
}
