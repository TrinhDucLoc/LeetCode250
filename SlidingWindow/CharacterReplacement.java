import java.util.HashSet;
import java.util.Set;

public class CharacterReplacement {

  public int characterReplacement(String s, int k) {
    int res = 0;
    Set<Character> hashSet = new HashSet<>();

    for (char c : s.toCharArray()) {
      if (!hashSet.contains(c)) {
        hashSet.add(c);
      }
    }

    for (char c : hashSet) {
      int count = 0, l = 0;
      for (int r = 0; r < s.length(); r++) {
        if (s.charAt(r) == c) {
          count++;
        }

        while ((r - l + 1) - count > k) {
          if (s.charAt(l) == c) {
            count--;
          }
          l++;
        }
        res = Math.max(res, r - l + 1);
      }
    }
    return res;
  }
}
