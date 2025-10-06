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

/*
Window: "AA"     → count=2, need 0 replacements → valid, length=2
Window: "AAB"    → count=2, need 1 replacement  → valid, length=3
Window: "AABA"   → count=3, need 1 replacement  → valid, length=4
Window: "AABAB"  → count=3, need 2 replacements → invalid! (2 > k)
  Shrink: "ABAB" → count=2, need 2 replacements → invalid!
  Shrink: "BAB"  → count=1, need 2 replacements → invalid!
  Shrink: "AB"   → count=1, need 1 replacement  → valid, length=2
...
 */
