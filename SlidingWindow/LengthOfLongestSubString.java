import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> hashSet = new HashSet<>();
    int l = 0, res = 0;
    for (int i = 0; i < s.length(); i++) {
      while (hashSet.contains(s.charAt(i))) {
        hashSet.remove(s.charAt(l));
        l++;
      }
      hashSet.add(s.charAt(i));
      res = Math.max(res, hashSet.size());
    }
    return res;
  }
}
