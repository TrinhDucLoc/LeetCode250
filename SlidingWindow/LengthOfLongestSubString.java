import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }

  // s = "abcabcbb" -> 3
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> hashSet = new HashSet<>();
    int l = 0, res = 0;

    for (int r = 0; r < s.length(); r++) {
      while (hashSet.contains(s.charAt(r))) {
        hashSet.remove(s.charAt(l));
        l++;
      }
      hashSet.add(s.charAt(r));
      res = Math.max(res, hashSet.size());
    }
    return res;
  }
}
