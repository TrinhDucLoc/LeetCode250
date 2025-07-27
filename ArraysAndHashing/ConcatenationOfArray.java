public class ConcatenationOfArray {
  public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] result = new int[n * 2];
    int index = 0;
    for (int i = 0; i < n * 2; i++) {
      if (index < n) {
        result[i] = nums[index];
        index++;
      } else {
        index = 0;
        result[i] = nums[index];
        index++;
      }
    }
    return result;
  }
}

/*
nums = [1,2,3]
=> n = 3
result = [1,2,3,1,2,3]
=> resultLength = 3*2

index = 0
Loop from i to resultLength
Set result[i] with nums[index]
 */