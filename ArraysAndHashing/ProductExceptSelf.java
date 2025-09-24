public class ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    res[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }

    int productNum = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] = res[i] * productNum;
      productNum = nums[i] * productNum;
    }
    return res;
  }
}

/*
input: nums = [1,2,3,4]
output: res = [20,12,8,6]

res: [1,1,2,6]
i=2, productNum = 4 => res: [1,1,8,6]
i=1, productNum = 12 => res: [1,12,8,6]
i=0, productNum = 24 => res [24,12,8,6]
 */
