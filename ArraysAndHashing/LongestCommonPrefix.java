public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String result = "";

    int minLengthArray = Integer.MAX_VALUE;
    for (String str : strs) {
      if (str.length() < minLengthArray) {
        minLengthArray = str.length();
      }
    }
    for (int i = 0; i < minLengthArray; i++) {
      for (int j = 1; j < strs.length; j++) {
        if (strs[0].charAt(i) != strs[j].charAt(i)) {
          return result;
        }
      }
      result = result + strs[0].charAt(i);
    }

    return result;
  }
}
