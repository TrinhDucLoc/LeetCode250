public class RemoveElement {

  public static void main(String[] args) {
    int[] nums = {3, 2, 2, 3};
    System.out.println(removeElement(nums, 3));
  }

  public static int removeElement(int[] nums, int val) {
    int step = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[step] = nums[i];
        step++;
      }
    }
    return step;
  }
}
